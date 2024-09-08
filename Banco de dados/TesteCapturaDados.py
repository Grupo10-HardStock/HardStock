import psutil
#from mysql.connector import connect, Error


# Fazendo um loop para mostrar a porcentagem de uso da CPU
# Depois vou fazer um while com break para rodar na aplicação
# e quando o usuário digitar para parar ele para
# Mas tenho que aprender a fazer isso em python
a = 1
while True:
    resposta = input("Deseja parar o monitoramento dos componentes? ")
    if resposta.lower() == 'sim':
        break
    else:
        while(a < 10):
            print(f"O porcentual de uso da CPU atualmente está em {psutil.cpu_percent(interval=2)}")
            a = a + 1
    # While para mostrar a velocidade atual da CPU a máxima e a minima
            print(f"A velocidade da CPU é {psutil.cpu_freq()}")
            
            cpu_times = psutil.cpu_times()
# Retorna o tempo ativo da CPU em segundos tem que fazer a conversão depois
            tempoAtivo = cpu_times.user + cpu_times.system
            print(f"O tempo ativo da cpu é {tempoAtivo:.2f}")

# Retorna muitas informações sobre o tempo de uso da CPU
#print(psutil.cpu_times(percpu=True))

            usoDisco = psutil.disk_usage('/')
# Comando que retorna todas as métricas juntas
            print(usoDisco)

# Comando que mostra o quanto do disco já foi utilizado
            print(f"O disco rígido tem um total {usoDisco.total} GB")
            print(f"já foi utilizado {usoDisco.used} do disco rígido")
            print(f"Está disponível {usoDisco.free}GB do disco rígido")
            print(f"Está sendo utilizado {usoDisco.percent}% do disco rígido")

# Guardando numa variável os valores de velocidade de leitura,etc.
            io_counters = psutil.disk_io_counters()

            print(io_counters)
            print(f"O tempo total em milisegundos para leitura {io_counters.read_time}")
            print(f"O tempo total em milisegundos para gravação {io_counters.write_time}")

            net_io_counters = psutil.net_io_counters()

            print(net_io_counters)

            print(f"O total de bytes enviados pela rede foi {net_io_counters.bytes_sent} KB/s")
            print(f"O total de bytes recebidos pela rede foi {net_io_counters.bytes_recv} KB/s")


# Memória RAM

            mem = psutil.virtual_memory()
            print(mem)

            print(f"O total de memória ram é {mem.total}")
            print(f"A quantidade de memória ram disponível é {mem.available}")
            print(f"O porcentual de uso da memória ram é {mem.percent}")
            print(f"A quantidade de memória ram utlizada é {mem.used}")

# Fazendo conexões com o banco de dados

"""config = {
    
'user':'root',
'password':'10062006Dudu',
'host': '192.168.56.1',
'database': 'HardStock'
}


try:
    db = connect(**config)
    if db.is_connected():
        db_info = db.get_server_info()
        print('Connected to MySQL server version -', db_info)
        porc_cpu = psutil.cpu_percent()
        with db.cursor() as cursor:
            query = ("INSERT INTO Dados(fkComponente, fkComputador,registro) VALUES "
                     "(1,1,{porc_cpu})")
            value = [round(perc_cpu, 2)]
            cursor.execute(query, value)
            db.commit()
            print(cursor.rowcount, "registro inserido")
        
        cursor.close()
        db.close()

except Error as e:
    print('Error to connect with MySQL -', e)
    """


