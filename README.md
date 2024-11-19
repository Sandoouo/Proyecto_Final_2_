.
Implementar un programa para simular el funcionamiento de una clÌnica de medicina, el cual
debe tener las siguientes funcionalidades:
1. (10%)Dos tipos de usuarios. Tipo administrador que puede agregar o quitar mÈdicos
para asignarle citas. Tipo usuario final el cual puede agendar y asistir a citas con los
diferentes mÈdicos. La informaciÛn de los usuarios debe ser grabada en un archivo texto
y como mÌnimo se debe almacenar para cada uno: Correo electrÛnico (el cual se usa
para ingresar al sistema), nombres, n ̇mero de identificaciÛn, tipo de usuario y clave de
ingreso. Debe existir una clase que maneje estos usuarios.
2. (15%)DiseÒar una clase abstracta Medico que tiene como atributos el nombre del
mÈdico, el n ̇mero de identificaciÛn, el valor por hora para consulta y una lista de fechas
que indica los dÌas que ya se encuentran reservados para citas. Debe tener los mÈtodos
abstractos CalcularValorCita, el cual debe recibir el tiempo en minutos y retornar el valor
total a cobrar y un mÈtodo abstracto llamado VerificarDisponibilidad, que recibe como
par·metro una fecha y retorna si para esa fecha hay disponibilidad de horario del
mÈdico para agendarle citas.
3. (15%)DiseÒar dos clases hijas de la clase Medico. Una llamada MedicoEspecialista que
tiene como particularidad al menos una especialidad mÈdica, tiene un horario de
atenciÛn de 8 am a 5 pm de lunes a viernes y una llamada MedicoCirujano que tiene
como particularidad una lista de los tipos de cirugÌa que puede realizar, tiene un horario
de atenciÛn de lunes a viernes de 8 am a 2 pm. La especialidad debe ser una clase que
contiene el nombre de la especialidad y la universidad donde fue presentada. Estas
clases deben implementar los mÈtodos abstractos de la clase padre.
4. (30%)Desarrollar una interfaz que permita que un usuario administrador agregue
mÈdicos para poder atender citas mÈdicas o realizar cirujias. Para esto debe existir una
clase llamada Clinica que tiene como atributo una lista (con polimorfismo) de los
distintos mÈdicos que puede tener una clÌnica (Especialistas y cirujanos). Debe tener dos
mÈtodos, uno que se llame crearMedico el cual permite que el administrador digite por
pantalla los datos del mÈdico y se guarde en un archivo plano. Este archivo contiene
todos los mÈdicos ofrecidos por la clÌnica. Un mÈtodo llamado cargarMedicos que debe
llenar la lista de mÈdicos con la informaciÛn que est· almacenada en el archivo.
5. (30%)Agendar cita. Para el usuario final debe existir una interfaz que permita buscar
mÈdicos (con polimorfismo) para agendar una cita. El usuario selecciona si necesita un
especialista o un cirujano, la fecha y la hora de la cita. Se debe mostrar una lista con los
mÈdicos que cumplan estos criterios y que tengan disponibilidad en esa fecha y hora.
De esta lista el usuario puede seleccionar alguno de los mÈdicos y ver la informaciÛn
completa del mÈdico, fecha y hora en la que puede agendar la cita y debe poder agendar

Nota: Todos los mÈtodos y funcionalidades deben ser diseÒadas utilizando clases y herencia. Los
atributos de las clases deben estar encapsulados. Utilice colecciones o arreglos para manejar los
alejamientos en memoria. Los atributos y mÈtodos sugeridos son los b·sicos solicitados, sin
embargo, el estudiante puede agregar otros de acuerdo con su diseÒo
