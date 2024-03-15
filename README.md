# Requisitos
```
- JDK 17
- mvn 3.87+
```

# Pasos para Dockerizarlo
```
- Posicionarse en la raiz del proyecto
- mvn clean package
- imagen: docker build -t money-exchange-img .
- container:  docker run -d --name money-exchange-ctr -p 8080:8080 money-exchange-img:latest
```
