(ns acme.app)

(defn- scale-on-mouse-enter [^js/Object el ^js/Object data]
  (..
   el
   (addEventListener
    "mouseenter"
    (fn []
      (.. el -object3D -scale (copy (.-to data)))))))

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn init []
  (.registerComponent
   js/AFRAME
   "scale-on-mouseenter"
   (clj->js
    {:schema
     {:to {:default {:x 2.5
                     :y 2.5
                     :z 2.5}
           :type "vec3"}}

     :init
     (fn []
       (this-as
        this
        (let [this-data ^js/Object (.-data this)
              this-el ^js/Object (.-el this)]
          (scale-on-mouse-enter this-el this-data))))})))
