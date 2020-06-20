(ns project.aula5)

(def estoque {"Mochila" 10, "Camiseta" 5})
(println estoque)

(println "Temos" (count estoque) "elementos")
(println "Chaves" (keys estoque))
(println "Valores" (vals estoque))

(def estoque {:mochila 10 :camiseta 5})
(println (assoc estoque :cadeira 3))
(println (assoc estoque :mochila 1))

(println (update estoque :mochila inc))
(println (update estoque :mochila dec))

(defn tira-um
  [valor]
  (println "Tirando um")
  (- valor 1))

(println (update estoque :camiseta tira-um))
(println (update estoque :camiseta #(- % 1)))

(println estoque)
(println (map #(+ % 1) (map #(val %1) estoque)))

(println (dissoc estoque :mochila))






(def pedido {:mochila {:quantidade 4, :preco 80},
             :camiseta {:quantidade 3, :preco 40}
             })
(println "\n\n\n\n")
(println pedido)
(def pedido (assoc pedido :chaveiro {:quantidade 1 :preco 10}))
(println pedido)
(println (pedido :mochila))
(println ((pedido :mochila) :quantidade))

(println (get pedido :mochila))
(println (get pedido :cadeira {}))

(println (:mochila pedido {}))
(println (:cadeira pedido {}))

(println (:quantidade (:mochila pedido)))

(println (-> pedido :mochila :quantidade))

(println "Start...")
(defn funcao1 [valor] (println "Somando" valor "com 1") (+ valor 1))
(defn funcao2 [funcao1] (println "Somando resultado funcao1 com 1") (+ (funcao1 1) 1))
(defn funcao3 [valor3] (println "Somando" valor3 "com 1") (+ valor3 1))
(defn funcao4 [valor4] (println "Multiplicando por 3") (* valor4 3))

(println "Threading" (-> funcao1 funcao2 funcao3 funcao4 funcao1))
(println "Threading2" (-> 0 funcao1 funcao1 funcao1))
