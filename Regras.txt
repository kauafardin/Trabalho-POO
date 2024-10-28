Sistema de Gestão de Frota de Carros Elétricos com Eletropostos

Objetivo: Desenvolver um sistema para gestão de uma frota de carros elétricos utilizando conceitos de Programação Orientada a Objetos (POO) em Java. O projeto deve aplicar os conceitos de classes, objetos, herança, encapsulamento, associação, agregação e composição. A implementação deve focar exclusivamente na lógica de negócio, sem a necessidade de interface gráfica 

Descrição do Sistema:
Uma empresa de mobilidade sustentável precisa de um sistema para gerenciar sua frota de carros elétricos e os eletropostos disponíveis ao longo das rotas. O sistema deve ser capaz de registrar e controlar informações sobre os veículos elétricos, motoristas, viagens realizadas, carregamento de baterias e a manutenção dos veículos. Além disso, os eletropostos (pontos de recarga) devem ser considerados nas viagens para planejamento adequado de paradas para recarga.

Funcionalidades Obrigatórias:
   1.    Cadastro de Veículos Elétricos:
   •    Cada carro elétrico deve possuir um número de identificação único, marca, modelo, ano de fabricação, capacidade total da bateria (em kWh), e autonomia máxima (em km).

   •    Os carros elétricos são divididos em três categorias principais:

   •    Carros Compactos: Autonomia de até 200 km e tempo médio de carga de 4 horas.

   •    Carros Sedans: Autonomia de até 400 km e tempo médio de carga de 6 horas.

   •    SUVs Elétricos: Autonomia acima de 400 km e tempo médio de carga de 8 horas.

   •    Implementar métodos para adicionar, remover e listar todos os carros elétricos da frota.

   2.    Gestão de Motoristas:
   •    Cada motorista deve ter um nome, número de identificação, número da carteira de habilitação e registro do nível de experiência em direção de veículos elétricos (iniciante, intermediário, avançado).
   •    Implementar métodos para cadastrar novos motoristas e listar os motoristas existentes.

   3.    Cadastro e Gerenciamento de Eletropostos:
   •    Cada eletroposto deve ter uma identificação única, local (cidade e/ou estrada), número de vagas disponíveis para carregamento simultâneo e tempo médio de carregamento por veículo.

   •    Implementar métodos para registrar novos eletropostos e consultar os postos de recarga disponíveis ao longo das rotas das viagens.

   4.    Registro de Viagens com Planejamento de Paradas para Recarga:
   •    Permitir que um motorista realize uma viagem com um carro elétrico, registrando a quilometragem percorrida e o destino.

   •    Verificar a autonomia restante do carro antes de iniciar a viagem e planejar automaticamente as paradas nos eletropostos ao longo da rota, caso a carga não seja suficiente para completar a viagem.

   •    Considerar a disponibilidade de vagas nos eletropostos ao planejar as paradas e recalcular a rota se o eletroposto estiver cheio.

   •    Atualizar automaticamente a autonomia do veículo após cada viagem realizada e após cada recarga nos eletropostos.

   5.    Gestão de Carregamento de Baterias:
   •    Registrar os eventos de recarga de bateria para cada carro elétrico, incluindo a data, o eletroposto utilizado e a quantidade de energia recarregada (em kWh).

   •    Atualizar a autonomia do carro após a recarga, garantindo que ela não exceda a capacidade máxima da bateria.

   •    Manter um histórico de todas as recargas de cada veículo, disponível para consulta.

   6.    Relatórios e Consultas:
   •    Gerar um relatório que liste todos os veículos com autonomia inferior a 20% da capacidade total da bateria.

   •    Listar todas as viagens realizadas por um determinado motorista, incluindo as distâncias percorridas, os veículos utilizados e os eletropostos onde as recargas foram realizadas.

   •    Consultar o histórico de recargas de um carro elétrico específico.

   •    Listar todos os carros que precisam de manutenção com base na quilometragem percorrida ou na vida útil da bateria.

Regras e Restrições Adicionais:
   •    Utilize herança para modelar a hierarquia de veículos elétricos (por exemplo, uma classe base CarroEletrico com subclasses CarroCompacto, CarroSedan, e SUVEletrico).

   •    Utilize o encapsulamento para proteger os dados dos veículos, motoristas, viagens e recargas, garantindo que apenas métodos específicos possam acessar e alterar essas informações.

   •    Utilize composição para relacionar as viagens com os objetos de veículos, motoristas e eletropostos, garantindo que uma viagem só possa existir se houver um veículo, motorista e plano de recarga adequados.

Requisitos Técnicos:
   •    O trabalho deve ser implementado em Java, utilizando apenas as bibliotecas padrão (não são permitidos frameworks externos).

   •    Não é permitido o uso de interface gráfica. A entrada e saída de dados devem ser realizadas por meio de métodos e estrutura de dados adequadas.

   •    O código deve estar organizado, seguindo boas práticas de programação, com classes e métodos bem estruturados e comentados.
