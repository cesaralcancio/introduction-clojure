(ns project.aula6)

(def pedido {:mochila {:quantidade 2, :preco 80},
             :camiseta {:quantidade 3, :preco 40}})

(defn imprime-e-15
  [valor]
  (println "valor" (class valor) valor)
  15)

(println (map imprime-e-15 pedido))

(println "\n\n\n")
(defn novo
  [[chave valor]]
   (println chave "<e>" valor)
   15)

(println (map novo pedido))

(defn imprime-e-15 [[chave valor]] valor)
(println (map imprime-e-15 pedido))

(defn preco-dos-produtos [[chave valor]]
  (* (:quantidade valor) (:preco valor)))

(println (map preco-dos-produtos pedido))
(println (reduce + (map preco-dos-produtos pedido)))

(println "\n\n\n\n")

(defn preco-dos-produtos [[_ valor]]
  (* (:quantidade valor) (:preco valor)))

(println (map preco-dos-produtos pedido))
(println (reduce + (map preco-dos-produtos pedido)))

(println "\n\n\n\n")

(defn total-do-pedido
  [pedido]
  (reduce + (map preco-dos-produtos pedido)))
(println (total-do-pedido pedido))

(println "\n\n\n\n")

; THREAD LAST ->> THREAD FIRST ->
(defn total-do-pedido
  [pedido]
  (->> pedido
       (map preco-dos-produtos)
       (reduce +)))
(println (total-do-pedido pedido))


(println "\n\n\n\n")

(defn preco-total-do-produto [produto]
  (* (:quantidade produto) (:preco produto)))

(defn total-do-pedido
  [pedido]
  (->> pedido
       vals
       (map preco-total-do-produto)
       (reduce +)))
(println (total-do-pedido pedido))















(println "Filter")
(def pedido {:mochila {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}
             :chaveiro {:quantidade 1}})

(defn gratuito?
  [item]
  (<= (get item :preco 0) 0))

(println "Filtrando gratuitos")
(println (filter gratuito? (vals pedido)))

(defn gratuito?
  [[_ valor]]
  (<= (get valor :preco 0) 0))

(println "Filtrando gratuitos")
(println (filter gratuito? pedido))

(defn gratuito?
  [item]
  (<= (get item :preco 0) 0))

(println "Filtrando gratuitos")
(println (filter (fn [[_ valor]] (gratuito? valor)) pedido))

(println "Filtrando gratuitos")
(println (filter #(gratuito? (second %)) pedido))

; Versao completa de uma funcao DEFN
(defn pago?
  [item]
  (not (gratuito? item)))

(println (pago? (:mochila pedido)))

; versao utilizando comp
(def pago (comp not gratuito?))

(println (pago? (:mochila pedido)))

; versao utilizando lambda
(def pago #(not gratuito?))

(println (pago? (:mochila pedido)))

; versao utilizando fn
(def pago (fn [v] not gratuito? v))

(println (pago? (:mochila pedido)))


(def clientes [
               { :nome "Guilherme"
                :certificados ["Clojure" "Java" "Machine Learning"] }
               { :nome "Paulo"
                :certificados ["Java" "Ciência da Computação"] }
               { :nome "Daniela"
                :certificados ["Arquitetura" "Gastronomia"] }])

(println (reduce + (map count (map :certificados clientes))))

(->> clientes
     (map :certificados)
     (map count)
     (reduce +)
     println)

