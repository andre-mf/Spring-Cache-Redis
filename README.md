# Spring Boot Cache com Redis

💻 Projeto para demonstração de uso do Spring Boot Cache com Redis.

## Para quê usar cache com Redis na aplicação Spring Boot?

Ao escolher pontos específicos do sistema (que possuem dados que não são modificados com tanta frequência, por exemplo), é possível adotar a estratégia de *cache* para aumento de performance, visto que a operação do Redis é em memória.

Nesta aplicação, o *cache* foi utilizado no método **findAll()** de acesso ao banco de dados no *service* de Produto. Desta forma, a listagem de produtos é acessada para *cache* em um primeiro momento. Já em uma segunda chamada (dentro do TTL spring.cache.redis.time-to-live=60000 definido em application.properties), o Spring não mais acessará o banco de dados, e sim os dados *cacheados*.

É possível notar o sistema de *cache* plenamente em execução através dos logs no console, quando em um primeiro acesso é exibido **Hibernate: select p1_0.id,p1_0.nome,p1_0.preco from produto p1_0**, assim como, por meio do Redis CLI Monitor, pode-se notar a operação "SET" "produtos::SimpleKey". Já nas demais chamadas ao método, os acessos ao banco de dados não são mais realizados, em seu lugar podemos notar operações "GET" "produtos:SimpleKey" no monitor do Redis 🤠

## Instalação do Redis

- Download em https://redis.io/download/

- Execução de container pelo Docker Compose

- Execução de container pelo Docker com o comando:

  ```docker
  docker run --name redis -v ./data:/data -p 6379:6379 -d redis/redis-stack:latest
  ```

- Caso a execução do Redis seja através do Docker, para acesso ao Redis CLI, basta executar:

  ```docker
  docker exec -it redis redis-cli
  ```

## Execução do projeto em uma IDE

Para este projeto foi escolhido o banco de dados **MySQL**. O host e a senha devem ser definidos por variáveis de ambiente na IDE (${MYSQL_HOST) e ${MYSQL_PWD}). Como informado no application.properties, o banco de dados deverá possuir o *schema* **rediscache**.