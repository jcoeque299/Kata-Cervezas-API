# Documentación API Kata Cervezas

En este archivo voy a documentar todos los endpoints de la API de este proyecto, describiendo como usarlos

Todos estos ejemplos están disponibles para ser ejecutados en el archivo dentro de la carpeta insomnia

## Endpoints

Todos los endpoints de este proyecto están situados bajo la url "/api"

### Beer

#### GET

+ **/beers** --> Lista todos los registros existentes de cervezas en la base de datos. Ejemplo:
  
  ```
  localhost:8080/api/beers
  ```
  
  Esto listará todas las cervezas

+ **/beers?page=X&size=X** --> Lista todos los registros existentes de cervezas en la base de datos y los divide en páginas. La página predeterminada a mostrar será la primera, y las páginas se dividirán en grupos de 5 cervezas. Uso:

  + **Manualmente**: Se deberá introducir dos queries en la URL. Ejemplo:
  
  ```
  localhost:8080/api/beers?page=3&size=8
  ```
  
  Esto devolverá la cuarta página, dividiendo las páginas en grupos de 8

  + **Insomnia**: Dentro del apartado queries, crear dos campos. Uno con nombre page y el valor deseado, y otro con nombre size y el valor deseado. Ejemplo:
  
  ```
  NAME    VALUE
  page    3
  size    8
  ```
  
  Mismo resultado que manualmente

+ **/beer/{id}** --> Busca una cerveza por ID y la devuelve. Ejemplo:

  ```
  localhost:8080/api/beer/1
  ```
  
  Devolverá la cerveza con ID 1

#### POST

+ **/beer** --> Para introducir una cerveza nueva, se deberá enviar una petición POST a esta URL, con un body que deberá tener todos los datos de una cerveza. Ejemplo:

  ```
  {
    "brewery_id": 812,
    "name": "Hocus Pocus",
    "cat_id": 11,
    "style_id": 116,
    "abv": 4.5,
    "ibu": 0.0,
    "srm": 0.0,
    "upc": 0.0,
    "filepath": "",
    "descript": "Our take on a classic summer ale.  A toast to weeds, rays, and summer haze.  A light, crisp ale for mowing lawns, hitting lazy fly balls, and communing with nature, Hocus Pocus is offered up as a summer sacrifice to clodless days.\r\n\r\nIts malty sweetness finishes tart and crisp and is best apprediated with a wedge of orange.",
    "add_user": 0,
    "last_mod": "2010-07-22T20:00:20"
  }
  ```
  Este ejemplo creará una cerveza con la ID 5915, ya que es la siguiente ID libre en la base de datos. Es posible especificar una ID para la cerveza a crear, para ello, habrá que añadir un campo "id" en el body  

  Si se introdujese una cerveza con una ID ya existente, se lanzará un error 409 con un mensaje avisando de que la cerveza ya existe. Si se crea la cerveza, se devolverá un código 201 con un location header cuyo contenido apunta a la URL del recurso creado, y un body conteniendo la cerveza creada

#### PUT

+ **/beer/{id}** --> Si se quiere modificar una cerveza, se deberá enviar una petición PUT a esta URL, especificando la id de la cerveza a modificar, y enviando un body con todos los datos de la cerveza, incluyendo aquellos que no vayan a cambiar
  
  Enviando la petición a /beer/5915, siguiendo el ejemplo de antes:

  ```
  {
    "brewery_id": 812,
    "name": "Nombre cambiado",
    "cat_id": 11,
    "style_id": 116,
    "abv": 4.5,
    "ibu": 0.0,
    "srm": 0.0,
    "upc": 0.0,
    "filepath": "",
    "descript": "Our take on a classic summer ale.  A toast to weeds, rays, and summer haze.  A light, crisp ale for mowing lawns, hitting lazy fly balls, and communing with nature, Hocus Pocus is offered up as a summer sacrifice to clodless days.\r\n\r\nIts malty sweetness finishes tart and crisp and is best apprediated with a wedge of orange.",
    "add_user": 0,
    "last_mod": "2010-07-22T20:00:20"
  }
  ```

  Una vez realizada esta petición, la cerveza con ID 5915 tendría su nombre cambiado y se devolverá un código 200 y un body conteniendo la cerveza modificada. Si la cerveza no existe, se devolverá un código 404 avisando de que la cerveza no existe

  Es posible cambiar la ID de la cerveza con una petición PUT. Para ello, hay que introducir un campo "id" en el body de la request. Una vez realizada la operación, los datos de la cerveza que tenía la ID introducida en el body se sobreescribirán por los de la ID introducida en el enlace de la request. Ejemplo:

  ```
  {
    "id": 5914,
    "brewery_id": 812,
    "name": "Nombre e ID cambiados",
    "cat_id": 11,
    "style_id": 116,
    "abv": 4.5,
    "ibu": 0.0,
    "srm": 0.0,
    "upc": 0.0,
    "filepath": "",
    "descript": "Our take on a classic summer ale.  A toast to weeds, rays, and summer haze.  A light, crisp ale for mowing lawns, hitting lazy fly balls, and communing with nature, Hocus Pocus is offered up as a summer sacrifice to clodless days.\r\n\r\nIts malty sweetness finishes tart and crisp and is best apprediated with a wedge of orange.",
    "add_user": 0,
    "last_mod": "2010-07-22T20:00:20"
  }
  ```

  Los datos de la cerveza con ID 5914 se sobreescribirían por los de la cerveza con ID 5915. Si no se encuentra la cerveza a sobreescribir, se lanzará un error 404 detallando que la cerveza a sobreescribir no existe  

#### PATCH

+ **/beer/{id}** --> Si solamente se quiere modificar parcialmente una cerveza, es mejor idea utilizar una petición PATCH, en lugar de la petición PUT. La diferencia entre ambas, es que con esta petición PATCH solo tienes que enviar los campos que quieres modificar, en lugar de tener que reenviar todos los datos de la cerveza

  Siguiendo el ejemplo anterior, enviando la petición a /beer/5915:

  ```
  {
    "name": "Nombre cambiado con PATCH"
  }
  ```
  
  Solamente enviando estos datos, es posible cambiar el nombre de la misma forma que con la petición PUT. Si la petición es exitosa, se devolverá un código 200 y un body conteniendo la cerveza modificada. Si la cerveza a modificar no se encuentra en la base de datos, se devolverá un error 404

#### DELETE

+ **/beer/{id}** --> Para eliminar una cerveza, simplemente se deberá enviar una petición DELETE especificando la ID de la cerveza a eliminar. Si la petición se realiza con éxito, se devolverá un código 204. Si la cerveza no existe, se avisará mediante un código 404

### Brewerie

#### GET

+ **/breweries** --> Devuelve todos los datos de cervecerías que se encuentren en la base de datos
  ```
  localhost:8080/api/breweries
  ```
+ **/breweries?page=X&size=X** --> Devuelve los datos de cervecerías dividido en páginas. El valor predeterminado es mostrar la primera página dividida de 5 en 5. Esto se puede modificar de varias formas

  + **Manualmente**: Se deberá introducir dos queries en la URL. Ejemplo:

  ```
  localhost:8080/api/breweries?page=3&size=8
  ```

  Esto devolverá la cuarta página, dividiendo las páginas en grupos de 8

  + **Insomnia**: Dentro del apartado queries, crear dos campos. Uno con nombre page y el valor deseado, y otro con nombre size y el valor deseado. Ejemplo:

  ```
  NAME    VALUE
  page    3
  size    8
  ```

  Mismo resultado que manualmente

+ **/brewerie/{id}** --> Busca una cervecería por ID y la devuelve. Ejemplo:

  ```
  localhost:8080/api/brewerie/1
  ```

  Devolverá la cervecería con ID 1

### Category

#### GET

+ **/categories** --> Devuelve todos los datos de categorías de cervezas que se encuentren en la base de datos
  ```
  localhost:8080/api/categories
  ```
+ **/categories?page=X&size=X** --> Devuelve los datos de categorías de cervezas dividido en páginas. El valor predeterminado es mostrar la primera página dividida de 5 en 5. Esto se puede modificar de varias formas

  + **Manualmente**: Se deberá introducir dos queries en la URL. Ejemplo:

  ```
  localhost:8080/api/categories?page=3&size=8
  ```

  Esto devolverá la cuarta página, dividiendo las páginas en grupos de 8

  + **Insomnia**: Dentro del apartado queries, crear dos campos. Uno con nombre page y el valor deseado, y otro con nombre size y el valor deseado. Ejemplo:

  ```
  NAME    VALUE
  page    3
  size    8
  ```

  Mismo resultado que manualmente

+ **/categorie/{id}** --> Busca una categoría por ID y la devuelve. Ejemplo:

  ```
  localhost:8080/api/categorie/1
  ```

  Devolverá la categoría con ID 1

### Style

#### GET

+ **/styles** --> Devuelve todos los datos de estilos de cervezas que se encuentren en la base de datos
  ```
  localhost:8080/api/styles
  ```
+ **/styles?page=X&size=X** --> Devuelve los datos de estilos de cerveza dividido en páginas. El valor predeterminado es mostrar la primera página dividida de 5 en 5. Esto se puede modificar de varias formas

  + **Manualmente**: Se deberá introducir dos queries en la URL. Ejemplo:

  ```
  localhost:8080/api/styles?page=3&size=8
  ```

  Esto devolverá la cuarta página, dividiendo las páginas en grupos de 8

  + **Insomnia**: Dentro del apartado queries, crear dos campos. Uno con nombre page y el valor deseado, y otro con nombre size y el valor deseado. Ejemplo:

  ```
  NAME    VALUE
  page    3
  size    8
  ```

  Mismo resultado que manualmente

+ **/style/{id}** --> Busca un estilo por ID y lo devuelve. Ejemplo:

  ```
  localhost:8080/api/beer/1
  ```

  Devolverá el estilo con ID 1