# santander

[![License](https://img.shields.io/badge/license-MIT-a1356a)](LICENSE.txt)

**Cadastro de clientes** - micro serviço para cadastro de clientes.

## Docker mysql para armazenar os logs

```cmd
docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=santander -e MYSQL_DATABASE=santander -p 3306:3306 -d mysql:latest
```

## C4 model

![C4 model](https://github.com/netobasilio/santander/blob/main/santander.png?raw=true)
