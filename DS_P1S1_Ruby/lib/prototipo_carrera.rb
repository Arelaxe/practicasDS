#encoding: utf-8
require_relative "prototipo_bicicleta.rb"
require_relative "prototipo_carrera.rb"
require_relative "carrera_carretera.rb"
require_relative "carrera_montana.rb"
require_relative "bicicleta_carretera.rb"
require_relative "bicicleta_montana.rb"
require_relative "gestor_prototipos.rb"


module DS_P1S1_Ruby
  
  class PrototipoCarrera
    
    attr_accessor:num_bicicletas,:porcentaje_retirada,:retiradas,:terminadas
    attr_reader:bicicletas
    
    def initialize(num_bicicletas)
      @num_bicicletas = num_bicicletas
      
      @bicicletas = Array.new
      @retiradas = Array.new
      @terminadas = Array.new
      
      for i in 0..@num_bicicletas
        @retiradas << false
        @terminadas << false
      end
    end
    
    def clone
      # Realmente no usaremos este método, ya que el gestor trabaja con las clases concretas
      PrototipoCarrera.new(@num_bicicletas)
    end
    
    def inicio
      gestor = GestorPrototipos.new
      
      if (self.is_a? CarreraCarretera)
        bici_original = gestor.crear_copia("BicicletaCarretera")
      
        for i in 0..@num_bicicletas
          nueva_bici = bici_original.clone
          nueva_bici.identificador = i
          @bicicletas << nueva_bici
        end
        puts "Comienza la carrera de carretera!"
        
      else
        bici_original = gestor.crear_copia("BicicletaMontana")
      
        for i in 0..@num_bicicletas
          nueva_bici = bici_original.clone
          nueva_bici.identificador = i
          @bicicletas << nueva_bici
        end
        puts "Comienza la carrera de montaña!"
      end
      
      num_retiradas = @num_bicicletas * @porcentaje_retirada
      
      segundo_retirada = rand(60);
      
      @bicicletas.each do |bicicleta|
        bicicleta.correr
      end
      
      for i in 0..60
        sleep(1)
        puts "SEGUNDO "+i.to_s+"\n"
        
        if (i==segundo_retirada)
          ya_retiradas = 0
          
          while (ya_retiradas < num_retiradas)
            id_retirada = rand(@num_bicicletas)
            
            if (!@retiradas.at(id_retirada) && !@terminadas.at(id_retirada))
              @retiradas[i] = true
              ya_retiradas += 1
              puts "Se ha retirado la bicicleta"+i.to_s+"\n"
            end
          end
        end
        
        @bicicletas.each do |bicicleta|
          if (i==bicicleta.tiempo_llegada)
            puts "Ha llegado a la meta la bicicleta "+i.to_s+"\n"
            @terminadas[i] = true
          end
        end
      end
      
      puts "Ha terminado la carrera\n"
      
    end
  end
end
