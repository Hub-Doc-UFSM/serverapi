Sistema de Gestão de Restauração de Documentos (SGRD)

 Sobre o Projeto

O SGRD é uma solução de software desenvolvida para gerenciar e rastrear o processo de recuperação de documentos danificados, com foco principal em acervos atingidos por desastres naturais, como enchentes.

O sistema resolve o problema logístico complexo de rastrear milhares de documentos físicos enquanto eles transitam por diversos departamentos de laboratório (higienização, secagem, reparo, etc.). Ele garante a integridade da cadeia de custódia, permite fluxos de trabalho personalizados por cliente (Órgão) e assegura que procedimentos técnicos sejam registrados com precisão.

🎯 Principais Soluções

Rastreabilidade Total: Monitoramento em tempo real de cada documento, sabendo exatamente em qual estágio ele está e com qual técnico.

Fluxos Personalizados: Capacidade de definir procedimentos (etapas) diferentes para cada Órgão (ex: Banco do Brasil vs. Caixa Econômica).

Controle Hierárquico: Organização lógica de acervos em Órgão > Caixa > Maço > Documento.

Identificação Única: Geração e leitura de códigos de barras para agilidade operacional.

Controle de Qualidade: Gestão de "Pareceres Técnicos" restritos a Arquivistas qualificados.

🚀 Tecnologias Utilizadas

Este projeto foi construído utilizando o que há de mais moderno no ecossistema Java, garantindo performance e longevidade.

Java 25: Utilizando as features mais recentes da linguagem para alta performance e segurança.

Spring Boot 4.0: Framework base para agilidade no desenvolvimento e configuração.

Spring Data JPA: Abstração robusta para persistência de dados e ORM.

Flyway: Versionamento e migração automatizada do esquema do banco de dados (fundamental para evolução segura do modelo de dados).

Spring Security + JWT: Autenticação e Autorização via tokens Json Web Token (Stateless).

Lombok: Redução de boilerplate code (Getters, Setters, Builders).

Bean Validation (Hibernate Validator): Validação de dados de entrada via anotações.

PosgreSQL: Banco de dados relacional escolhido pela consistência (ACID) necessária ao processo.

🏗 Arquitetura do Projeto

O sistema foi desenhado seguindo as melhores práticas de Engenharia de Software, utilizando uma Arquitetura em Camadas com separação estrita de responsabilidades. Isso facilita a manutenção, testes e escalabilidade.

A estrutura do código segue o seguinte fluxo de dados:

Controller (Camada de Apresentação): Pontos de entrada da API REST. Recebem as requisições HTTP e retornam os DTOs. Não contêm regra de negócio.

DTO (Data Transfer Object): Objetos simples usados puramente para transferir dados entre o cliente (Frontend/Mobile) e o servidor, garantindo que as Entidades do banco não sejam expostas diretamente.

Mapper: Responsável pela conversão inteligente entre DTOs e Entities, desacoplando a API do modelo de dados.

Service (Camada de Negócio): O coração do sistema. Aqui residem as regras de negócio, validações de fluxo (ex: verificar se um órgão possui a etapa X), lógica de geração de código de barras e regras de permissão de cargos.

Repository (Camada de Dados): Interface de comunicação com o banco de dados via JPA/Hibernate.

Entities (Modelo de Domínio): Representação espelhada das tabelas do banco de dados (Mapeamento ORM).

🛠 Pré-requisitos para Execução

Para rodar este projeto localmente, você precisará ter instalado:

Java JDK 25 (Verifique se a variável de ambiente JAVA_HOME está configurada corretamente).

Maven 3.8+ (Gerenciador de dependências).

Postgre 18 (Instância rodando localmente ou em container Docker).

⚙️ Configuração e Instalação

Clone o repositório:

git clone (https://github.com/Hub-Doc-UFSM/serverapi.git)
cd serverapi


Configuração do Banco de Dados:
Edite o arquivo src/main/resources/application.properties com suas credenciais:

spring.datasource.url=jdbc:postgresql://localhost:5432/sisrest_db
spring.datasource.username=postgres
spring.datasource.password=admin
spring.datasource.driver-class-name=org.postgresql.Driver


Compilação e Execução:

mvn clean install
mvn spring-boot:run


O Flyway executará automaticamente os scripts SQL de migração ao iniciar a aplicação.

🔐 Segurança e Perfis de Acesso

O sistema implementa controle de acesso baseado em cargos (Role-Based Access Control):

ADMIN: Acesso total ao sistema, gestão de órgãos, fluxos e usuários.

ARQUIVISTA: Pode executar todas as etapas de restauração e é o único autorizado a emitir o Parecer de Degradação Final.

TECNICO / BOLSISTA: Podem executar etapas de restauração (banho, higienização, etc.), mas não podem emitir pareceres.

📦 Estrutura de Pacotes (Exemplo)

com.restauracao.sistema
│
├── controller/      # REST Controllers
├── dto/             # Records ou Classes POJO para transferência de dados
├── entity/          # Entidades JPA (@Entity)\
├── mapper/          # Interfaces de Mapeamento (MapStruct ou manual)
├── repository/      # Interfaces JpaRepository
└── service/         # Regras de Negócio (@Service)


📄 Licença

Este projeto está sob a licença MIT.
