Para que la aplicacion funcione necesitar ejecutar el .sql en el workbench, y 
ejecutar (
	use casa_expres;
	delimiter |
	create procedure mostrartotal(id int, tipos_gasto int)
	    begin
	        select sum(g.CANTIDAD) 
 	           from gastos g inner join casa c on g.IDINMUEBLE_GASTO=c.IDINMUEBLE 
	            where c.IDUSUARIO=id and g.TIPO_GASTO_ID=tipos_gasto;
	    end |
	delimiter ;


	delimiter |
	create procedure mostrarcasa(id int, tipos_gasto int)
	    begin
	        select sum(CANTIDAD) from gastos where IDINMUEBLE_GASTO=id and TIPO_GASTO_ID=tipos_gasto;
	    end |
	delimiter ;
)
y luego modificar las credenciales de acceso a la base de datos en el documento que hay en el proyecto.