#encoding: utf-8
require_relative "prototipo_bicicleta.rb"
require_relative "prototipo_carrera.rb"
require_relative "carrera_carretera.rb"
require_relative "carrera_montana.rb"
require_relative "bicicleta_carretera.rb"
require_relative "bicicleta_montana.rb"
require_relative "gestor_prototipos.rb"

module DS_P1S1_Ruby
  class Main
    @@gestor = GestorPrototipos.new
    
    carrera_carretera = @@gestor.crear_copia("CarreraCarretera")
    
    carrera_carretera.inicio
  end
end