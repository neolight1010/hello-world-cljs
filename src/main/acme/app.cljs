(ns acme.app)

(enable-console-print!)
(set! *warn-on-infer* true)

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn init []
  (.registerComponent
   js/AFRAME
   "scale-on-mouseenter"
   (clj->js
    {:schema
     {:to {:default "2.5 2.5 2.5"
           :type "vec3"}}

     :init
     (fn []
       (this-as
        this
        (let [this-data ^js/Object (.-data this)
              this-el ^js/Object (.-el this)]
          (..
           this-el
           (addEventListener
            "mouseenter"
            (fn []
              (.. this-el -object3D -scale (copy (.-to this-data)))))))))})))
