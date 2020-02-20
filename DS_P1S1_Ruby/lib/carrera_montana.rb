#encoding: utf-8

require_relative "prototipo_carrera"
module DS_P1S1_Ruby
  class CarreraMontana < PrototipoCarrera
    def initialize(num_bicis)
      super(num_bicis)
      @porcentaje_retirada = 0.2
    end
  end
end
