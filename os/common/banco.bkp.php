<?php

function conecta_banco(){
    $conexao = mysql_connect('localhost','root','senha')
            or die ('Ocorreu um erro no acesso ao SGBD! <br /> Erro: '.
                        mysql_error());
    mysql_select_db('ordemservico')
            or die ('Ocorreu um erro no acesso a base de dados! <br /> Erro: '.
                        mysql_error());
}

function desconecta_banco(){
    mysql_close(mysql_connect('localhost','root','senha'));
}

function listarDadosOS($solicitante,$tipo_solic){
    conecta_banco();
    if($tipo_solic == '2'){
    $resultado = mysql_query("SELECT o.cod_os, t.descricao_equip, o.serv_solicitado, s.nome, o.status, o.data_cadastro
                                            FROM os o, solicitante s, tipoequipamento t
                                            WHERE (o.cod_solicitante = s.cod_solicitante) AND                                                  
                                                  (o.descricao_equip = t.descricao_equip) AND
                                                  ((o.status = 'Aberta' OR o.status = 'Em andamento'))
                                            ORDER BY o.cod_os");
    }else{


	 $resultado = mysql_query("SELECT o.cod_os, t.descricao_equip, o.serv_solicitado, s.nome, o.status, o.data_cadastro
                                            FROM os o, solicitante s, tipoequipamento t
                                            WHERE (o.cod_solicitante = s.cod_solicitante) AND
                                                  (o.descricao_equip = t.descricao_equip) AND
						  (s.email = '$solicitante')
                                            ORDER BY o.cod_os");
}
    if(!$resultado) echo mysql_error();
    desconecta_banco();
    return $resultado;
}

function buscarDadosOS($busca, $coluna){
    conecta_banco();
    // caso a opcao escolhida tenha sido 'todas' mostra todas as OS
    if($coluna == "todas"){
         $resultado = mysql_query("SELECT o.cod_os, t.descricao_equip, o.serv_solicitado, s.nome, o.status, o.data_cadastro
                                   FROM os o, solicitante s, tipoequipamento t
                                   WHERE (o.cod_solicitante = s.cod_solicitante) AND
                                         (o.descricao_equip = t.descricao_equip) AND
                                         (s.nome LIKE '%$busca%' OR t.descricao_equip LIKE '%$busca%' OR o.status LIKE '%$busca%'
                                               OR o.serv_solicitado LIKE '%$busca%' OR o.data_cadastro LIKE '%$busca%')
                                   ORDER BY o.cod_os");
    }else{
         $resultado = mysql_query("SELECT o.cod_os, t.descricao_equip, o.serv_solicitado, s.nome, o.status, o.data_cadastro
                                   FROM os o, solicitante s, tipoequipamento t
                                   WHERE (o.cod_solicitante = s.cod_solicitante) AND
                                         (o.descricao_equip = t.descricao_equip) AND
                                         ($coluna like '%$busca%')
                                   ORDER BY o.cod_os");
    }
    if(!$resultado) echo mysql_error();
    desconecta_banco();
    return $resultado;
}

//insere os dados do solicitante na base de dados conforme os valores passados nos campos do formulário
function inserirSolicitante($nome, $cargo, $siape, $email, $tipoSolicitante){
    conecta_banco();
    $resultado = mysql_query("INSERT INTO solicitante (nome, cargo, siape, email, tipo_solic)
                                          VALUES ('$nome','$cargo','$siape', '$email', '$tipoSolicitante')");
    if(!$resultado) echo mysql_error();
    desconecta_banco();
    return $resultado;
}

//insere os dados do equipamento na base de dados conforme os valores passados nos campos do formulário
function inserirTipoEquipamento($descricao_equip){
    conecta_banco();
    $resultado = mysql_query("INSERT INTO tipoequipamento (descricao_equip)
                                          VALUES ('$descricao_equip')");
    if(!$resultado) echo mysql_error();
    desconecta_banco();
    return $resultado;
}

//insere os dados do tombamento na base de dados conforme os valores passados nos campos do formulário
function inserirTombamento($tombamento, $descricao_equip, $marca, $modelo){
    conecta_banco();
    $resultado = mysql_query("INSERT INTO equipamento (tombamento, descricao_equip, marca, modelo)
                                          VALUES ('$tombamento', '$descricao_equip', '$marca', '$modelo')");
    if(!$resultado) echo mysql_error();
    desconecta_banco();
    return $resultado;
}

//insere os dados da OS na base de dados, conforme os valores passados nos campos do formulário
function inserirOS($solicitante,$equipamento, $servico_sol, $setor_origem, $status,$hora_entrada,$data_entrada){
    conecta_banco();
    $resultado = mysql_query("INSERT INTO os (cod_solicitante, descricao_equip, serv_solicitado, setor_origem,
                                              status, hora_cadastro, data_cadastro)
                                      VALUES ('$solicitante','$equipamento', '$servico_sol', '$setor_origem', '$status','$hora_entrada','$data_entrada')");
    if(!$resultado) echo mysql_error();
    desconecta_banco();
    return $resultado;
}

function excluirOS($codigoOS){
    conecta_banco();
    $resultado = mysql_query("DELETE FROM os WHERE cod_os = '$codigoOS'");
    if(!$resultado) echo mysql_error();
    desconecta_banco();
    return $resultado;
}

function validarUsuario($usuario){
    conecta_banco();
    
    $consulta = mysql_query("SELECT * FROM solicitante WHERE email = '$usuario'");
    
    if (mysql_num_rows($consulta) != 0){
        $resultado = true;
    }else{
        $resultado = false;
    }
    desconecta_banco();
    return $resultado;
}
 
function buscarPermissao($usuario, $senha){
    conecta_banco();
    
    $resultado = mysql_query("SELECT * FROM solicitante WHERE email = '$usuario' AND siape ='$senha'");
    //verifica usuario e senha
  
    desconecta_banco();
    return $resultado;
}



?>
