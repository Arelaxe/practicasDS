#encoding: utf-8

module DS_P1S1_Ruby
  class PrototipoBicicleta
    attr_accessor:identificador, :tiempo_llegada
    def initialize(id)
      @identificador = id
    end
    
    def clonar
      raise NotImplementedError
    end
    
    def correr
      @tiempo_llegada = rand(30..60)
    end
  end
end
