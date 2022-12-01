#Proyecto Api Market

### Caracteristicas

- API de supermercado online;
- Desarrollada en java con Framework Spring;
- Cuenta con seguridad jwt por lo que debera generar token para interactuar;
- Version de Java utilizada 8 ;
- Version de Spring 2.5.5 ;
- implementaciones: MapStruct version 1.5.3:
   con esto evitamos que el proyecto se acople a una base de datos puntual Es decir si en un futuro se cambia la base de datos.  Incluso si se la cambia por una que no sea SQL, que por ejemplo se cambie a Mongo donde hay collecciones y eso haria que la api tenga que cambiar completamente. Por eso al implementar MapStruct nos evitamos esto simplemente creando un nuevo mapper y el codigo seguira funcionando exactamente igual sin tener que modificarlo.
- ####DOCUMENTACION
- implementaciones: Swagger version 3.0.0
-  Swagger ui para visualizacion  version 3.0.0




# Editor utilizado netbeans version 15

![](https://res.cloudinary.com/dkm0hdlgz/image/upload/v1669881926/Api-market/descarga_vjhdef.png)



##demostracion de las peticiones en entorno local


###Imagenes

GET: obtener todos los productos  (Sin Autenticación )

![](https://res.cloudinary.com/dkm0hdlgz/image/upload/v1669878566/Api-market/obtener_todas_las_compras_sin_token_efapox.png)

> Se deniega la peticion porque no esta autenticado. Error 403

#

GET: obtener todas las productos  (Ya Con Autenticación )

![](https://res.cloudinary.com/dkm0hdlgz/image/upload/w_1000,ar_16:9,c_fill,g_auto,e_sharpen/v1669878567/Api-market/Obtener_todas_las_compras_l724lc.png)

> Utilizando el Token accede a las peticiones. Status 200
#

GET: obtener todas las compras de un usuario  (Con Autenticación )

![](https://res.cloudinary.com/dkm0hdlgz/image/upload/w_1000,ar_16:9,c_fill,g_auto,e_sharpen/v1669878566/Api-market/Obtener_compras_de_un_cliente_xyrvwk.png)

> Se obtienen  las compras de un usuario atraves de su ID.
#

GET: obtener todas las compras de un usuario  (SIN Autenticación )

![](https://res.cloudinary.com/dkm0hdlgz/image/upload/w_1000,ar_16:9,c_fill,g_auto,e_sharpen/v1669878566/Api-market/Obtener_compras_del_cliente_denegada_rht7pa.png)

> Se rechaza la solicitud por no estar autenticado. Error 403 no tienes perimisos

#

#####POST: Autenticacion usando Usuario y Contraseña 

![](https://res.cloudinary.com/dkm0hdlgz/image/upload/w_1000,ar_16:9,c_fill,g_auto,e_sharpen/v1669878566/Api-market/loguearse_laond3.png)

> Se loguea y recibe el Jason Web Token
 #

JASON WEB TOKEN:  donde debe colocarse el token

![](https://res.cloudinary.com/dkm0hdlgz/image/upload/w_1000,ar_16:9,c_fill,g_auto,e_sharpen/v1669878566/Api-market/mostrar_como_usar_el_token_y7awi9.png)

> En Header se agraga una KEY = Authorization y en el VALUE = Bearer +espacio+ se pega el Token que se obtuvo al loguearse en el paso anterior. Ejemplo: "Bearer eynasdjnasjcuc638f4fhv" sin comillas.
-
-
-
-
####EJEMPLO DE AUTENTICACION YA EN AMBIENTE DE PRODUCCION
SE UTILIZO AZURE PARA EL DESPLIEGUE DE LA API
 #

POST  autenticacion usando la url de produccion

![](https://res.cloudinary.com/dkm0hdlgz/image/upload/w_1000,ar_16:9,c_fill,g_auto,e_sharpen/v1669878567/Api-market/Prueba_desde_deploy_Azure_ejwhzi.png)

> Se obtiene el Token utilizando la url Azure.

-
-
-
####Agregaciones importantes
-La api cuenta tambien con las posibilidades de VER AGREGAR MODIFICAR Y ELIMINAR los productos del supermercado
-Se puede Realizar compras con un usuario donde elegiras los productos que quieras luego poder ver todas las compras de cada usuario como se vio anteriormente.

####Si tiene interes por probar todas las caracteristicas de este proyecto puede comunicarse para facilitarle la coleccion de peticiones de Postman para que interactue libremente con la Api.
-
-
-
-> https://apimarket.azurewebsites.net/api  +peticion

Author: Diego Villan
###End
