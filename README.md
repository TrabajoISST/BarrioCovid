# BarrioCovid
_Aplicación para la interaccion entre compradores y vendedores locales en situaciones excepcionales_

## Pre- requisitos
### Software necesario

- Java JDK (Java Development Kit) versión 8 o superior
- Servidor Web Apache Tomcat versión 9

### Ficheros configuración para servidor Tomcat:

#### 1) Añadir en server.xml: 
```
<Connector protocol="org.apache.coyote.http11.Http11NioProtocol" port="8443" maxThreads="200"
    scheme="https" secure="true" SSLEnabled="true" keystoreFile="/path/to/isst.jks"
    keystorePass="covid19" clientAuth="false" sslProtocol="TLS"/>
```
    
#### 2) Certificados:
- ca.crt
- isst.jks

## Autores
* Alberto Pascual Jimenez
* Edwin Chuchón Alva
* Javer García Cespedes
* Luis Delgado Assiego
* Lucila Bao Simón
