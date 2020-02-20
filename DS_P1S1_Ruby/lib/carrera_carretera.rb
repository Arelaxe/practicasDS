# encoding: utf-8
require_relative "prototipo_bicicleta.rb"
require_relative "prototipo_carrera.rb"
require_relative "carrera_carretera.rb"
require_relative "carrera_montana.rb"
require_relative "bicicleta_carretera.rb"
require_relative "bicicleta_montana.rb"
module DS_P1S1_Ruby
  class PrototipoCarrera
  end
  class CarreraCarretera < PrototipoCarrera
    def initialize(num_bicis)
      super(num_bicis)
      @porcentaje_retirada = 0.1
    end
    
    def clonar
      
    end
  end
end
