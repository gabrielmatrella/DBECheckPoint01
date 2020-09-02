#DBECheckPoint01
## Funcionalidades

####Rotas sem autentição
<ul>
    <li>
        <strong>[POST] /auth</strong> -> Recebe um usuário no body e quando valido, gera um accessToken, para ser utilizado no header Authorization de todas as rotas seguras.<br>
        Exemplo de body: {
                             "email": "hospital-master@example.com",
                             "password": "1234"
                         }
    </li>
</ul>

####Rotas protegidas

<p>É necessário enviar nas requisições protegidas o header de Authorization contendo o seguinte valor: Bearer {accessToken}, o accessToken pode ser recuperado realizando o post das credenciais do exemplo no /auth.</p>
<ul>
    <li>
        <strong>[POST] /receptores</strong> -> Cria um novo receptor<br>
        Exemplo de body: { 
                             "nome": "Gabriel",
                             "sobrenome": "Matrella",
                             "dataNascimento": "1996-12-09",
                             "tipoSanguineo": "A_POS",
                             "telefone": "123456",
                             "rg": "123456",
                             "cpf": "123456",
                             "orgao": "Coração",
                             "score": 2
                         }
    </li>
    <li>
       <strong>[PUT] /receptores/{codigo}</strong> -> Atualiza um receptor ${codigo} com os dados passado no body<br>
       Exemplo de body com telefone atualizado: { 
                            "nome": "Gabriel",
                            "sobrenome": "Matrella",
                            "dataNascimento": "1996-12-08",
                            "tipoSanguineo": "A_POS",
                            "telefone": "8492139",
                            "rg": "123456",
                            "cpf": "123456",
                            "orgao": "Coração",
                            "score": 2
                        }
    </li>
    <li> 
       <strong>[GET] /receptores</strong> -> Busca todos os receptores cadastrados do hospital
    </li>
    <li>
       <strong>[GET] /receptores/{codigo}</strong> -> Busca um receptor pelo código
    </li>
    <li>
       <strong>[DELETE] /receptores/{codigo}</strong> -> Arquiva um receptor pelo código passado
    </li>
</ul>

## Arquitetura
Sistema com arquitetura rest, utilizando tokens JWT como meio de autentição em cima do ambiente Spring, sendo que as tecnologias utilizadas são: Spring Data, Spring Web, Spring Security, Spring Validation.
##Como executar o projeto
1. Faça o clone do repositorio
2. Abra o projeto no intellij ou sua ide de preferencia
3. Baixe as dependencias do POM.xml
4. Execute o projeto
5. Utilize o usuário que já vem cadastrado por padrão para criar um token e posteriormente consumir as rotas seguras da api  -> email: "hospital-master@example.com", password: "1234"  
##Integrantes
```bash
Agatha Nayara  RM82585
Gabriel Matrella RM80387
Julia Assunção RM78706
Lucas Cesar Soares RM83757
Leandro Farias RM81850
```