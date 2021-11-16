# ProyectoTransacciones
Repositorio GIT: https://github.com/Victor-PV/ProyectoTransacciones.git

#NOTA:

Se valorará la claridad, orden, legibilidad (“clean code”) y eficiencia en el
código, así como que esté debidamente comentado. Errores leves suponen 30%
menos de nota de cada apartado. Errores graves suponen la pérdida de
puntuación en ese apartado.

Es requisito la implementación del modelo DAO.

Se penalizará un mal diseño que empeore la cohesión y acoplamiento.
Se requiere la implementación de un menú (interfaz o consola) para poder
probar el funcionamiento de la aplicación.

Es requisito que la aplicación sea funcional para poder valorarla.
Se entregará un único fichero zip o rar que contenga el proyecto completo junto
con la documentación adicional generada.

La puntuación final está supeditada a la superación de una evaluación personal
con la profesora donde se respondan a preguntas y supuestos formulados.


#ENUNCIADO:

Se quiere implementar una aplicación para la gestión del supermercado
“Supercomprín”. Este supermercado tiene la característica especial que
funciona en forma de prepago con una e-wallet del club Supercomprín.

	1. Para poder comprar en el supermercado, los clientes -que han de ser
	mayores de edad- se han de fidelizar haciéndose miembros del club
	Supercomprín, de forma gratuita y online simplemente informando sus
	datos básicos: nombre, apellidos, dni, fecha de nacimiento y email. En
	ese momento se les asigna una e-wallet.
	Dicha e-wallet tiene un saldo en euros, y una cuenta de puntos. Estos dos
	valores están inicialmente a 0. 

	2. El cliente sólo puede hacer una recarga de saldo en euros entre el día 1 y 5 de cada mes.

	3. Cada producto tiene asignado un valor en puntos, previamente definido
	por estrategias de márqueting y comerciales, que puede cambiar en
	cualquier momento. Se mantiene un stock de cada producto del supermercado.

	4. Cuando un cliente compra, se le descuenta el importe total de la compra
	de su saldo en euros en la e-wallet y se le suman los puntos
	correspondientes a su saldo.
	Si el cliente no tiene saldo suficiente en su e-wallet para pagar la compra, 
	el cliente no podrá llevarse los productos.

	5. Si el cliente devuelve el producto, se le devuelve el importe al saldo 
	de la e-wallet y los puntos de dicho producto -si los hubiera tenido- se 
	restan de la wallet. Si con la devolución, la e-wallet queda en saldo 
	menor a 5 puntos, el producto no se puede devolver.

	6. El cliente puede canjear los puntos por productos al realizar cualquier
	compra, pagando directamente con puntos de su e-wallet, siempre que dicha com


#SE PIDE:

	1 Diagrama de clases del modelo y análisis de la solución. 1 punto.

	2 Implementación de las operaciones de mantenimiento para e-wallet (alta,
	baja y modificación) teniendo en cuenta el modelo transaccional. Controlar
	excepciones y flujos de error. 2 puntos

	3 Implementación de la operación pagar una compra, mediante una
	transacción específica, asumiendo las siguientes simplificaciones del
	modelo a fin de facilitar la implementación: en cada compra se compra 1
	solo artículo, que debe descontarse del stock de almacén e incorporar el
	saldo de puntos a la ewallet. Controlar excepciones y flujos de error. 
	3 puntos

	4 Implementación de la operación devolver producto, mediante una
	transacción específica. Controlar excepciones y flujos de error. 3 puntos
	
	5 Implementación de optimización y mejoras adicionales. Documentación de
	pruebas del software realizadas. Uso de Git. 1 punto



