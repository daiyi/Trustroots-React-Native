(ns trustroots.shared.ui
  (:require [reagent.core :as r :refer [atom]]))

(def ReactNative (js/require "react-native"))
(def app-registry (.-AppRegistry ReactNative))

(set! js/React ReactNative)

; Common components
; ==================================================================
(def text        (r/adapt-react-class (.-Text ReactNative)))
(def view        (r/adapt-react-class (.-View ReactNative)))
(def image       (r/adapt-react-class (.-Image ReactNative)))
(def picker      (r/adapt-react-class (.-Picker      ReactNative)))
(def picker-item (r/adapt-react-class (.-Picker.Item ReactNative)))

(def list-view   (r/adapt-react-class (.-ListView    ReactNative)))
(def scroll-view (r/adapt-react-class (.-ScrollView  ReactNative)))
(def input       (r/adapt-react-class (.-TextInput   ReactNative)))
(def touchable-highlight
                 (r/adapt-react-class (.-TouchableHighlight ReactNative)))
(defn alert [title] (.alert (.-Alert ReactNative) title))

(def navigator
  (r/adapt-react-class (.-Navigator js/React)))

(def logo-img (js/require "./images/logo_144.png"))

; Material design / vector icons
; ==================================================================
(def MaterialIcon      (js/require "react-native-vector-icons/MaterialIcons"))
(def icon              (r/adapt-react-class MaterialIcon))

; Material design
; ==================================================================
(set! js/MaterialDesign (js/require "react-native-material-design"))
(def COLOR              (js->clj (.-COLOR js/MaterialDesign)   :keywordize-keys true))

(def card              (r/adapt-react-class (.-Card            js/MaterialDesign)))
(def card-body         (r/adapt-react-class (.-Card.Body       js/MaterialDesign)))
(def card-media        (r/adapt-react-class (.-Card.Media      js/MaterialDesign)))
(def card-actions      (r/adapt-react-class (.-Card.Actions     js/MaterialDesign)))


(def button            (r/adapt-react-class (.-Button          js/MaterialDesign)))
(def drawer-layout     (r/adapt-react-class (.-Drawer          js/MaterialDesign)))
(def drawer-header     (r/adapt-react-class (.-Drawer.Header   js/MaterialDesign)))
(def drawer-section    (r/adapt-react-class (.-Drawer.Section  js/MaterialDesign)))

(def PRIMARY_COLORS    (vec (map keyword (js->clj (.-PRIMARY_COLORS js/MaterialDesign)))))

(defn get-color [name] (:color (name COLOR)))

;; typo graphy
;; ===================================================================

(defn h1 [s]
  [text {:style
           {:font-size 30
           :font-weight "100"
           :margin-bottom 20
           :text-align "center"}} s]
)

(defn p [s]
  [text {:style
           {:font-size 16
           :font-weight "100"
           :margin-bottom 20
           :text-align "center"}} s]
)

(defn error-text [s]
  [text {:style
           {:font-size 16
           :font-weight "500"
           :color "red"
           :margin-bottom 20
           :text-align "center"}} s]
)


