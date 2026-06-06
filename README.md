# Buscador de CEPs

Buscador de CEPs que consome a API pública do ViaCEP, acessa e salva os resultados e exporta para um arquivo JSON.

## 🧠 Conhecimentos utilizados
- Java
- POO
- Listas e Coleções
- Consumo de API
- Tratamento de Erros
- Inteface Gráfica(AWT e Swing)

## 📋 Funcionalidades
- Receber um CEP digitado pelo usuário
- Consultar a API do ViaCEP via HTTP
- Deserializar o JSON da resposta com Gson para um record CEP
- Converter o record para um objeto dadosCEP
- Armazenar todos os CEPs buscados em uma lista
- Tratar erro caso o CEP não seja encontrado
- Repetir a busca até o usuário digitar "sair"
- Exportar todos os CEPs buscados para um arquivo CEP.json ao encerrar

## ▶️ Como executar
1. Clone o repositório
2. Abra no Eclipse
3. Execute a classe Main para acessar no console ou Execute a classe TelaCep para digitar e acessar o resultado numa tela
