#encoding: utf-8
require_relative "prototipo_bicicleta.rb"
require_relative "prototipo_carrera.rb"
require_relative "carrera_carretera.rb"
require_relative "carrera_montana.rb"
require_relative "bicicleta_carretera.rb"
require_relative "bicicleta_montana.rb"
module DS_P1S1_Ruby
  class Main
    @@carrera_original = CarreraCarretera.new(10)
    
    @@carrera_original.inicio()
    
  end
end