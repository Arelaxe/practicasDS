#encoding: utf-8
require_relative "prototipo_bicicleta.rb"
require_relative "prototipo_carrera.rb"
require_relative "carrera_carretera.rb"
require_relative "carrera_montana.rb"
require_relative "bicicleta_carretera.rb"
require_relative "bicicleta_montana.rb"
module DS_P1S1_Ruby
  class BicicletaCarretera < PrototipoBicicleta
    def initialize(id)
      super(id)
    end
    
    def clonar
      bicicleta_nueva = BicicletaCarretera.new(@identificador)
      bicicleta_nueva.tiempo_llegada = @tiempo_llegada
      
      return bicicleta_nueva
    end
  end
end
