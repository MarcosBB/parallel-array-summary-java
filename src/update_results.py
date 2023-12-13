from subprocess import run

n_possibilities = [5, 7]
t_possibilities = [1, 4, 16, 64, 256]

run(["javac", "Main.java"])

for n in n_possibilities:
    for t in t_possibilities:
        print(f"Rodando N: {n}, T: {t}")
        with open(f"../resultados/n{n}_t{t}.txt", 'w') as output_file:
            command = run(["java", "Main.java", str(n), str(t)], stdout=output_file, text=True)
            print(command)

print("Done!")
