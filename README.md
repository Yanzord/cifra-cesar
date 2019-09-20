# Cifra de César - Java
Por Yan Pereira
### Sumário
- [Introdução](https://github.com/Yanzord/cifra-cesar#introdução)
- [Requisitos](https://github.com/Yanzord/cifra-cesar#requisitos)
- [Execução](https://github.com/Yanzord/cifra-cesar#execução)
- [Funcionamento](https://github.com/Yanzord/cifra-cesar#funcionamento)
## Introdução
Este programa foi desenvolvido para o trabalho de *Cifra de César* da disciplina de Segurança da Informação, do curso
de Engenharia da computação do Centro Universitário de Técnologia - UNIFTEC.
O programa é um algorítmo de criptografia em Java que usa como base a [Cifra de César](https://pt.wikipedia.org/wiki/Cifra_de_C%C3%A9sar).
O algorítmo realiza a criptografia e/ou descriptografia de um texto e mostra o resultado ao usuário, a rotação padrão do algorítmo é três,
porém, ela pode ser alterada de acordo com a preferência do usuário. Para que a descriptografia funcione, o texto deve estar criptografado
com a rotação atual do programa.
## Requisitos
Para compilar e executar o programa é necessário alguns pré-requisitos configurados na máquina:
- O [Java JDK 8](https://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html) deve estar instalado, baixe a versão correspondente ao seu sistema e instale-a;
- As variáveis JAVA_HOME e CLASSPATH devem estar configuradas:
    1. Para windows 8 e 10:
        1. Abra o terminal;
        2. Execute os comandos abaixo:
            ```
            setx JAVA_HOME "<diretório-onde-jdk-foi-instalado>"
            setx CLASSPATH %JAVA_HOME%\lib
            setx PATH %PATH%;%JAVA_HOME%\bin
    	    ```
    	3. Feche o terminal.
    2. Para linux:
        1. Abra o Terminal;
        2. Edite o arquivo /etc/profile com o comando abaixo:
            ```
            sudo gedit /etc/profile
            ```
        3. Adicione as linhas abaixo no inicio do arquivo /etc/profile:
            ```
            JAVA_HOME=diretório-onde-jdk-foi-instalado
            CLASSPATH=.;$JAVA_HOME/lib
            PATH=$PATH:$JAVA_HOME/bin
            export JAVA_HOME
            export CLASSPATH
            export PATH
    		```
    	4. Salve o arquivo e efetue um logoff para que as variáveis de ambiente entrem em vigor.
## Execução
Para executar o programa é necessário compilá-lo:
- Abra o terminal;
    - Execute o comando abaixo para windows (para linux troque a \ por /):
        ```
        .\gradlew clean build
        ```
    - Após a execução do comando o programa será compilado na pasta build\libs.
- Após compilado, execute o programa:
    - No terminal, a partir do diretório do programa, acesse a pasta build\libs;
    - Execute o comando abaixo:
        ```
        java -jar cifra-cesar-yan-1.0-SNAPSHOT.jar
        ```
    - Após a execução do comando o programa será iniciado no terminal.
## Funcionamento
O programa é executado no console, há quatro opções disponíveis:
- Criptografar um texto: Permite inserir um texto a ser criptografado com base na chave de rotação atual, a saída é o texto criptografado sem caracteres especiais.
- Descriptografar um texto: Permite inserir um texto a ser descriptografado com base na chave de rotação atual, a saída é o texto original sem caracteres especiais.
- Alterar chave de rotação: Permite alterar a chave de rotação atual.
- Sair: permite sair do programa.

Os métodos de criptografia e descriptografia utilizam a posição do charactere na tabela ASCII para realizar a lógica de incremento e decremento
na posição do alfabeto. Caracteres especiais são retirados do texto e desconsiderados durante o processo, o texto de saída é em caixa alta
para facilitar a leitura.        				    	    