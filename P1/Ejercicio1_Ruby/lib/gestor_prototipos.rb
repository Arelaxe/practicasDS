#encoding: utf-8
require_relative "prototipo_bicicleta.rb"
require_relative "prototipo_carrera.rb"
require_relative "carrera_carretera.rb"
require_relative "carrera_montana.rb"
require_relative "bicicleta_carretera.rb"
require_relative "bicicleta_montana.rb"
require_relative "gestor_prototipos.rb"

module DS_P1S1_Ruby
  class GestorPrototipos
    
    def initialize
      # Lo ideal sería tener otra clase nueva Prototipo que actuase como una interfaz
      # y que solamente tuviese declarado el método clone. De este modo, el hashmap
      # creado sería de objetos de esta clase, y de la que heredan los distintos
      # subprototipos o clases concretas
      #
      # En este caso, como en Ruby podemos tener en un mismo hashmap objetos de distinto tipo,
      # no necesitamos implementar esa clase, sino que insertaremos carreras y bicicletas
      
      
      carrera_car = CarreraCarretera.new(10)
      carrera_mon = CarreraMontana.new(10)
      bicicleta_car = BicicletaCarretera.new(-1)
      bicicleta_mon = BicicletaMontana.new(-1)
      
      @catalogo = { "CarreraCarretera" => carrera_car, "BicicletaCarretera" => bicicleta_car,
                    "CarreraMontana" => carrera_mon, "BicicletaMontana" => bicicleta_mon}
    end
    
    def crear_copia (tipo)
      @catalogo[tipo].clone
    end
    
    def aniadir (nombre, obj)
      @catalogo << {nombre => obj}
    end
    
    def quitar (nombre)
      @catalogo.except!(nombre)
    end
  end
end 
