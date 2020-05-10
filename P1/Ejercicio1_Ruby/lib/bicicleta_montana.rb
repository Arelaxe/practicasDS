#encoding: utf-8
require_relative "prototipo_bicicleta.rb"
require_relative "bicicleta_montana.rb"


module DS_P1S1_Ruby
  
  class PrototipoBicicleta
  end
  
  class BicicletaMontana < PrototipoBicicleta
    
    def initialize(id)
      @identificador = id
    end
    
    def clone
      BicicletaMontana.new(@identificador)
    end
  end
end
