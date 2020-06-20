(ns project.aula2)

(defn valor-descontado
 [valor-bruto]
 "Retorna desconto"
 (if (> valor-bruto 100)
   (let [taxa-desconto (/ 10 100)
         desconto      (* valor-bruto taxa-desconto)]
      (println "Aplicando desconto" desconto "em" valor-bruto)
      (- valor-bruto desconto))
  valor-bruto))

(println (valor-descontado 100) "para Cesar")

; Atalhos:
; Option + Shift + L to reload REPL
; Option + Shift + P to run specific line on REPL
; Option + Shift + K para engolir o ultimo arg para funcao
; Option + Shift + J para vomitar o ultimo arg da funcao