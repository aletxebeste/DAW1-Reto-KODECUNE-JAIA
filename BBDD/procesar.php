<?php
// Colocar este archivo, por ejemplo en C:\xampp\htdocs\miweb
// luego en el formulario poner action="http://localhost/miweb/procesar.php"
// Datos de conexión
$servername = "localhost";
$username   = "root";
$password   = "";
$dbname     = "eventos_kodegune";

$nombre       = $_POST['nombre']      ?? '';  // el input del formulario se llama "nombre"
$apellidos  = $_POST['apellidos']   ?? '';
$email      = $_POST['email']       ?? '';
$telefono   = $_POST['telefono']    ?? '';
$fechai     = $_POST['fechai']      ?? '';

// Checkboxes -> convertir a 1 o 0
$eventotrans  = isset($_POST['eventotrans']) ? 1 : 0;
$eventoseg    = isset($_POST['eventoseg'])   ? 1 : 0;
$eventodiseno = isset($_POST['eventodiseno']) ? 1 : 0;
$eventonet    = isset($_POST['eventonet'])   ? 1 : 0;

// Conectar a MySQL
$conn = new mysqli($servername, $username, $password, $dbname);

// Comprobar conexión
if ($conn->connect_error) {
    // Finaliza la ejecución del script y muestra el mensaje indicado al usuario
	// PHP cierra la conexión al finalizar el script, $conn se destruye automáticamente
	die("Error de conexión: " . $conn->connect_error);
}

// Evitar insertar vacío
if ($nombre === "" || $apellidos === "" || $email === "") {
    // Finaliza la ejecución del script y muestra el mensaje indicado al usuario
	die("El nombre/apellido no puede estar vacío");
}

$sql = "INSERT INTO inscripciones 
(nombre, apellidos, email, telefono, fechai, eventotrans, eventoseg, eventodiseno, eventonet) VALUES 
('$nombre', '$apellidos', '$email', '$telefono', '$fechai', '$eventotrans', '$eventoseg', '$eventodiseno', '$eventonet')";
// Ejecutar
if ($conn->query($sql) === TRUE) {
    echo "<h2>¡Registro correcto!</h2>";
    echo "<p>Nombre insertado: " . $nombre . "</p>";
	echo "<p>Apellidos insertados: " . $apellidos . "</p>";
    echo "<p> Email: " . $email . "</p>";
    echo "<p> Telefono: " . $telefono . "</p>";
	echo "<p> Fechai: " . $fechai . "</p>";
    echo "<p> Eventotrans: " . $eventotrans . "</p>";
	echo "<p> Eventoseg: " . $eventoseg . "</p>";
    echo "<p> Eventodiseno: " . $eventodiseno . "</p>";
	echo "<p> Eventonet: " . $eventonet . "</p>";
    echo '<p><a href="javascript:history.back()">Volver</a></p>';
} else {
    echo "Error: " . $conn->error;
}

// Cerrar conexión
$conn->close();
?>