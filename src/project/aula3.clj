(ns project.aula3)

(defn maior-que-100?
  [valor-bruto]
  (> valor-bruto 100))

(defn valor-descontado
  [aplica? valor-bruto]
  "Retorna desconto"
  (if (aplica? valor-bruto)
    (let [taxa-desconto (/ 10 100)
          desconto      (* valor-bruto taxa-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(println (valor-descontado maior-que-100? 110) "versao mais clara")
(println (valor-descontado (fn [v] (> v 100)) 110) "versao com funcao anonima")
(println (valor-descontado #(> %1 100) 110) "versao com funcao anonima 2")
(println (valor-descontado #(> % 100) 110) "versao com funcao anonima 3")

(def maior-que-200? (fn [v] (> v 200)))
(println (valor-descontado maior-que-200? 210))

(def maior-que-300? #(> % 300))
(println (valor-descontado maior-que-300? 310))

; HIGH ORDER FUNCTION
; IMUTABLE