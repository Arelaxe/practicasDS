#encoding: utf-8

module DS_P1S1_Ruby
  class PrototipoCarrera
    attr_accessor:num_bicicletas,:porcentaje_retirada
    attr_reader:bicicletas
    def initialize
      
    end
    
    def inicio (num_bicis, prototipo)
      @num_bicicletas = num_bicis
      @prototipo = prototipo
      @bicicletas = Array.new
      
      for i in 0..@num_bicicletas
      end
      
      if (prototipo.instanceof? CarreraCarretera)
        puts "Comienza la carrera de carretera!"
      else
        puts "Comienza la carrera de montaña!"
      end
      
      num_retiradas = @num_bicicletas * @porcentaje_retirada
      
      segundo_retirada = rand(60);
      
      
    end
  end
end
