Synchronized

Introducción:
	Synchronized es un mecanismo de sincronización de Java. Estos mecanismos permiten que, cuando trabajamos con programación concurrente, no se produzcan errores sobre el recurso compartido.

Guía de uso:
	Usando la palabra “synchronized” indica que la parte sincronizada puede ser ejecutada por un hilo a la vez. Cada objeto tiene su propia llave/lock. El hilo necesita la llave para acceder al código sincronizado: si está libre, el hilo actual toma implícitamente el lock del objeto y entra a ejecutar el bloque o método; si el lock ya está tomado por otro hilo, el que está intentando entrar debe esperar (es suspendido/puesto en espera) hasta que el hilo que tomó el lock termine la ejecución del bloque o método para que se libere el lock implícitamente.
	Los datos delicados protegidos por métodos sincronizados deben ser privados.
	La forma de utilizar el synchronized en métodos es:
		public synchronized void incrementar() { … }
	Cada instancia de Object, y sus subclases, poseen bandera de bloqueo (lock implícito). Los tipos primitivos (no objetos) solo pueden bloquearse a través de los objetos que los encierren. No pueden sincronizarse variables individuales. Los objetos arreglos cuyos elementos son primitivos, pueden bloquearse, pero no sus elementos.

	Bloques sincronizados:
		El objeto es el que se utiliza como llave para acceder a la sección crítica.
			public void método() {
				synchronized(this) { … }
			}
		Se utiliza cuando la sección crítica no es todo el método, el método tiene parte de su código como sección crítica, y cuando hay dos o más secciones críticas en el método, separadas por secciones no críticas, para evitar bloqueos innecesarios.

	Métodos y bloques sincronizados:
		public synchronized void metodoUno() { … }

		public synchronized void metodoDos() {
			this.metodoUno(); }

	Si los métodos están en la misma clase, al ejecutar metodoDos() el hilo obtiene el lock de inmediato. Cuando desde metodoDos() se invoca a metodoUno(), el hilo ya no necesita volver a obtener el lock, porque ya lo tiene.
	Si los métodos están en distintas clases, al ejecutar metodoDos() el hilo obtiene el lock. Cuando desde metodoDos() se invoca a metodoUno(), el hilo necesita obtener el lock de este nuevo objeto, pero no libera el lock anterior que ya tiene en su poder. Mucho cuidado.
