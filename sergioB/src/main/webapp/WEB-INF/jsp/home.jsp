<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>AppPetShop: Gestão PetShop</title>
</head>
<body>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <div class="container-fluid">
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link active" href="/">AppPetShop</a></li>
                <li class="nav-item"><a class="nav-link" href="/cliente/listagem">Clientes</a></li>
                <li class="nav-item"><a class="nav-link" href="/animal/listagem">Animais</a></li>
                <li class="nav-item"><a class="nav-link" href="/servico/listagem">Serviços</a></li>
                <li class="nav-item"><a class="nav-link" href="/veterinario/listagem">Veterinários</a></li>
                <li class="nav-item"><a class="nav-link" href="/exame/listagem">Exames</a></li>
            </ul>
        </div>
    </nav>

    <div class="container mt-3">
        <div class="row text-center mb-4">
            <div class="col"><span class="badge bg-primary">Clientes: ${qtdeCliente}</span></div>
            <div class="col"><span class="badge bg-secondary">Animais: ${qtdeAnimal}</span></div>
            <div class="col"><span class="badge bg-success">Serviços: ${qtdeServico}</span></div>
            <div class="col"><span class="badge bg-warning">Veterinários: ${qtdeVeterinario}</span></div>
            <div class="col"><span class="badge bg-danger">Exames: ${qtdeExame}</span></div>
        </div>

        <h2 class="mb-3">Gestão Completa - AppPetShop</h2>
        
        <c:if test="${not empty clientes}">
            <h3>${titulo}</h3>
            <table class="table table-striped table-bordered">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Detalhes</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${clientes}">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.nome}</td>
                            <td>
                                <ul class="list-unstyled">
                                    <li><strong>CPF:</strong> ${item.cpf}</li>
                                    <li><strong>Email:</strong> ${item.email}</li>
                                    <li><strong>Telefone:</strong> ${item.tel}</li>
                                    <li><strong>Endereço:</strong> ${item.endereco != null ? item.endereco : "N/A"}</li>
                                </ul>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        
        <c:if test="${not empty animais}">
            <h3>Animais</h3>
            <table class="table table-striped table-bordered">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Registro</th>
                        <th>Data de Nascimento</th>
                        <th>Peso</th>
                        <th>Raça</th>
                        <th>Descrição</th>
                        <th>Cliente</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="animal" items="${animais}">
                        <tr>
                            <td>${animal.id}</td>
                            <td>${animal.nome}</td>
                            <td>${animal.registroAnimal}</td>
                            <td>${animal.dtNascimento != null ? animal.dtNascimento : "N/A"}</td>
                            <td>${animal.peso} kg</td>
                            <td>${animal.raca}</td>
                            <td>${animal.descricao}</td>
                            <td>${animal.cliente != null ? animal.cliente.nome : "Sem cliente associado"}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        
        <c:if test="${not empty servicos}">
            <h3>Serviços</h3>
            <table class="table table-striped table-bordered">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Descrição</th>
                        <th>Código</th>
                        <th>Preço</th>
                        <th>Emergência</th>
                        <th>Animal Associado</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="servico" items="${servicos}">
                        <tr>
                            <td>${servico.id}</td>
                            <td>${servico.descricao}</td>
                            <td>${servico.codigo}</td>
                            <td>R$ ${servico.preco}</td>
                            <td>${servico.emergencia ? "Sim" : "Não"}</td>
                            <td>${servico.animal != null ? servico.animal.nome : "Sem animal associado"}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        
        <c:if test="${not empty veterinarios}">
			<h3>Veterinários</h3>
			<table class="table table-striped table-bordered">
				<thead class="table-dark">
					<tr>
						<th>Nome</th>
						<th>CRV</th>
						<th>Especialidade</th>
						<th>Descrição</th>
						<th>Código</th>
						<th>Preço</th>
						<th>Emergência</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="veterinario" items="${veterinarios}">
						<tr>
							<td>${veterinario.nome}</td>
							<td>${veterinario.numCrv}</td>
							<td>${veterinario.especialidade}</td>
							<td>${veterinario.descricao}</td>
							<td>${veterinario.codigo}</td>
							<td>R$ ${veterinario.preco}</td>
							<td>${veterinario.emergencia ? "Sim" : "Não"}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		
		<c:if test="${not empty exames}">
			<h3>Exames</h3>
			<table class="table table-striped table-bordered">
				<thead class="table-dark">
					<tr>
						<th>Nome</th>
						<th>Característica</th>
						<th>Código do Laudo</th>
						<th>Laboratório</th>
						<th>Descrição</th>
						<th>Código</th>
						<th>Preço</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="exame" items="${exames}">
						<tr>
							<td>${exame.nome}</td>
							<td>${exame.caracteristica}</td>
							<td>${exame.codlaudo}</td>
							<td>${exame.laboratorio}</td>
							<td>${exame.descricao}</td>
							<td>${exame.codigo}</td>
							<td>R$ ${exame.preco}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/js/bootstrap.min.js"></script>
</body>
</html>
