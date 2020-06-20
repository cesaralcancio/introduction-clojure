(ns project.aula4)

(def precos [30 700 1000])

(println precos)
(println (precos 1))
(println (precos 2))

(println (get precos 4 0))

(println (update precos 0 inc))
(println (update precos 0 dec))

(def inc-value #(+ %1 %2 %3))

(println
  (inc-value 1 1 1) "Somando os tres valores")

(println (update precos 0 inc-value 4 4))
(println precos)

(defn aplica?
  [valor-bruto]
  (> valor-bruto 40))

(defn valor-descontado
  [valor-bruto]
  "Retorna desconto"
  (if (aplica? valor-bruto)
    (let [taxa-desconto (/ 10 100)
          desconto      (* valor-bruto taxa-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(println
  (valor-descontado 200))

(println "Antes:" precos)
(println "Depois:" (map valor-descontado precos))
(println "Depois:" (map #(println "Ola" %) precos))

(println (range 10))
(println (filter even? (range 10)))

(println (filter aplica? precos))

(println "Mapping & Filtering" (map valor-descontado (filter aplica? precos)))

(println "Reduce" (reduce #(+ %1 %2) precos))
(println "Reduce simplificado" (reduce + precos))
(println "Reduce" (reduce #(+ %1 %2) (range 10)))