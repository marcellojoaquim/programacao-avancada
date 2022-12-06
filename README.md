# Go Learn
É uma plataforma de cursos com o registro de alunos, professores, turmas, lead de alunos 
para possíveis novos alunos. Nesse repositório encontra-se o código fonte da aplicação.

## 🚀 Começando

Os requisitos serão implementados em um software criado pela equipe, nomeado Go Learn, que consistirá em uma plataforma virtual de ensino onde o usuário não só poderá encontrar os cursos disponíveis na plataforma, como também conseguirá o acesso de outras informações no seu perfil (aulas, professores etc.). 

### 📋 Requisitos obrigatórios para implementação do projeto

Os requisitos obrigatórios para a criação da aplicação são:

* Implementação do projeto utilizando o design pattern MVC.

* Implementação das classes e interfaces: Lead, Aluno, Turma, Professor, Curso, DiaAula e Feriado.

* A implementação de relações entre classes e interfaces utilizando boas práticas de Orientação a Objetos;  

* Realizar as operações CRUD para as entidades utilizando o padrão REST API. 

### EndPoints de acesso ao BackEnd

## Classe Curso
### GET 
* URL /golearn/cursos
* URL /gotlearn/cursos/{id}

### POST 
* URL /golearn/cursos
* BODY {"nomeCurso" : "String",
        "chaula" : "float",
        "chtotal" : "float",
        "turno" : "String",
        "valor" : "float"
    }

### PUT
* URL /gotlearn/cursos/{id}
* BODY {"nomeCurso" : "String",
        "chaula" : "float",
        "chtotal" : "float",
        "turno" : "String",
        "valor" : "float"
    }

### DELETE
* URL /gotlearn/cursos/{id}

## Classe Aluno

### GET 
* URL /golearn/aluno
* URL /golearn/aluno/{id}
### POST 
* URL /golearn/aluno
* BODY {"nome" : "String",
        "telefone" : "int",
        "cpf" : "int",
        "endereco" : [ "rua" : "string,
                        "numero" : "int",
                        "bairro" : "string",
                        "cidade" : "string"
                        ]
    }

### PUT
* URL /gotlearn/aluno/{id}
* BODY {"nome" : "String",
        "telefone" : "int",
        "cpf" : "int",
        "endereco" : [ "rua" : "string,
                        "numero" : "int",
                        "bairro" : "string",
                        "cidade" : "string"
                        ]
    }

### DELETE
* URL /gotlearn/aluno/{id}

## Classe Turma

### GET 
* URL /golearn/turma
* URL /golearn/turma/{id}
### POST 
* URL /golearn/turma
* BODY {"nomeTurma" : "String",
        "valor" : "float",
        "seg" : "int",
        "ter" : "int",
        "qua" : "int",
        "qui" : "int",
        "sex" : "int",
        "sab" : "int",
        "aluno" : ["nome" : "String",
        "telefone" : "int",
        "cpf" : "int",
        "endereco" : [ "rua" : "string,
                        "numero" : "int",
                        "bairro" : "string",
                        "cidade" : "string"
                        ]
                    ]
    }

### PUT
* URL /gotlearn/turma/{id}
* BODY {"nomeTurma" : "String",
        "valor" : "float",
        "seg" : "int",
        "ter" : "int",
        "qua" : "int",
        "qui" : "int",
        "sex" : "int",
        "sab" : "int",
        "aluno" : ["nome" : "String",
        "telefone" : "int",
        "cpf" : "int",
        "endereco" : [ "rua" : "string,
                        "numero" : "int",
                        "bairro" : "string",
                        "cidade" : "string"
                        ]
                    ]
    }

### DELETE
* URL /gotlearn/turma/{id}

## Classe Professor

### GET 
* URL /golearn/professor
* URL /gotlearn/professor/{id}
### POST 
* URL /golearn/professor
* BODY {"nomeCurso" : "String",
        "chaula" : "float",
        "chtotal" : "float",
        "turno" : "String",
        "valor" : "float"
    }

### PUT
* URL /gotlearn/professor/{id}
* BODY {"nomeCurso" : "String",
        "chaula" : "float",
        "chtotal" : "float",
        "turno" : "String",
        "valor" : "float"
    }

### DELETE
* URL /gotlearn/professor/{id}

## Classe Lead

### GET 
* URL /golearn/lead
* URL /gotlearn/lead/{id}
### POST 
* URL /golearn/lead
* BODY {"idLead" : "long",
        "nome" : "string",
        "telefone" : "int",
        "dataCadastro" : "String",
        "status_2" : "string",
        "dataNovoCadastro" : "string",
        "observacao" : "string"
    }

### PUT
* URL /golearn/lead/{id}
* BODY {"idLead" : "long",
        "nome" : "string",
        "telefone" : "int",
        "dataCadastro" : "String",
        "status_2" : "string",
        "dataNovoCadastro" : "string",
        "observacao" : "string"
    }

### DELETE
* URL /gotlearn/lead/{id}

## Classe Feriado

### GET 
* URL /golearn/feriado
* URL /gotlearn/feriado/{id}
### POST 
* URL /golearn/feriado
* BODY {"dataFeriado" : "string",
        "descricao" : "string"
    }

### PUT
* URL /gotlearn/feriado/{id}
* BODY {"dataFeriado" : "string",
        "descricao" : "string"
    }

### DELETE
* URL /gotlearn/feriado/{id}


## 🛠️ Construído com

* [Spring-boot](https://spring.io/projects/spring-boot) V-2.7.5 - O framework web.
* Java : V-17.0.0
* Visual Studio Code
* MySQL Workbench
* Postman

## ✒️ Autores

* **FABIO JR** - (https://github.com/FabioJro) | (https://www.linkedin.com/in/fabio-rodrigues-7010991bb/)
* **MARCELLO** - (https://github.com/marcellojoaquim) | (https://www.linkedin.com/in/marcello-joaquim-da-silva-6814bb69/)
* **WENNY** - (https://github.com/linkParaPerfil) | (https://www.linkedin.com/in/wenny-santana/)
* **LUCAS GABRIEL** - (https://github.com/Luqui17) | (https://www.linkedin.com/in/lucas-gabriel-921636234/)
* **FLÁVIO AUGUSTO** - (https://github.com/Flaviox625) | (https://www.linkedin.com/in/fl%C3%A1vio-augusto-costa-dos-santos-192587223/)
* **RODRIGO LUIZ** - (https://github.com/Rodrigolu1zz) | (https://www.linkedin.com/in/rodrigo-luiz-234b96194/)
* **JOSE VANILDO** - (https://github.com/jvanildo) | (https://www.linkedin.com/in/jos%C3%A9-vanildo-247954207/)

Você também pode ver a lista de todos os [Trabalhos](https://github.com/marcellojoaquim/programacao-avancada) que participaram deste projeto.

## 📄 Licença

GNU (GNU General Public License).

## 🎁 Expressões de gratidão

* Conte a outras pessoas sobre este projeto 📢;
* Convide alguém da equipe para uma cerveja 🍺;
* Um agradecimento publicamente 🫂;
* etc.


---
