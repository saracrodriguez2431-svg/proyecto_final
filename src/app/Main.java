package app;
import model.*;
import service.*;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaFacade plataforma = new SistemaFacade();

        System.out.println("--- SISTEMA DE GESTIÓN DE EVENTOS ---");

        // 1. CREACIÓN DEL EVENTO
        Evento concierto = new EventoBuilder()
                .setId("EV-2026")
                .setNombre("Concierto Juanes")
                .setCiudad("Armenia")
                .setFecha(LocalDateTime.of(2026, 5, 16, 20, 0))
                .setEstado(EstadoEvento.BORRADOR)
                .build();

        // Configuración de la Zona
        Zona zonaVip = new Zona("VIP", 400000.0);

        for (char fila ='A'; fila <= 'Z'; fila++) {
          for (int i = 1; i <= 10; i++) {
              String letraFila = String.valueOf(fila);
              String numeroAsiento = String.valueOf(i);

              zonaVip.agregarAsiento(new Asiento(String.valueOf(i), String.valueOf(fila)));
          }
        }
        List<Zona> zonas = new ArrayList<>();
        zonas.add(zonaVip);
        concierto.setZonas(zonas);
        plataforma.crearEvento(concierto);
        concierto.publicar();

        // 2. ENTRADA DE DATOS POR CONSOLA
        System.out.println("\n--- PROCESO DE COMPRA ---");
        System.out.print("\nIngrese su nombre completo: ");
        String nombreUser = scanner.nextLine();
        System.out.print("Ingrese su id: ");
        String idUser = scanner.nextLine();
        System.out.print("Ingrese su correo: ");
        String correoUser = scanner.nextLine();

        Usuario cliente = new Usuario(idUser, nombreUser, correoUser);
        concierto.agregarObserver(cliente);

        System.out.print("\nIngrese la fila (ej: A-Z): ");
        String fila = scanner.nextLine().toUpperCase();

        System.out.print("Ingrese el número de asiento (ej: 1): ");
        String numAsiento = scanner.nextLine();

        System.out.print("¿Desea incluir Parqueadero? (si/no): ");
        boolean quiereParqueadero = scanner.nextLine().equalsIgnoreCase("si");

        System.out.print("¿Desea incluir Foto con el artista? (si/no): ");
        boolean quiereFoto = scanner.nextLine().equalsIgnoreCase("si");

        // 3. EJECUCIÓN DE LA LÓGICA (Mismo resultado)
        CompraBase compraFinal = plataforma.comprarEntrada(
                concierto, fila, numAsiento, quiereParqueadero, quiereFoto
        );

        if (compraFinal != null) {
            System.out.println("\n========================================");
            System.out.println("RESUMEN DE SU COMPRA");
            System.out.println("\nCliente: " + cliente.getNombre());
            System.out.println("\nDetalle: " + compraFinal.getDescripcion());
            System.out.println("\nTotal a pagar: $" + compraFinal.getTotal());
            System.out.println("========================================");

            // Simulación de pago
            System.out.println("\nSeleccione método de pago: ");
            System.out.println("\n1. PSE (Transferencia Bancaria)");
            System.out.println("\n2. Tarjeta de Crédito/Débito");
            System.out.println("\n3. PayPal");
            System.out.println("\nOpción: ");
            int opcionPago = scanner.nextInt();
            scanner.nextLine();

            PagoContext pasarela = new PagoContext();
            if (opcionPago == 1) {
                pasarela.setStrategy(new PseAdapter());
            } else if (opcionPago == 2) {
                pasarela.setStrategy(new TarjetaAdapter());
            } else if (opcionPago == 3) {
                pasarela.setStrategy(new PaypalAdapter());
            } else {
                System.out.println("Opción no valida");
            }

            pasarela.pago(compraFinal.getTotal());

            // Cambio de estado
            if (compraFinal instanceof Compra) {
                ((Compra) compraFinal).setEstado(new CompraPagada());
                System.out.print("Estado final: ");
                ((Compra) compraFinal).procesar();
            }
        } else {
            System.out.println("\n[ERROR] El asiento " + fila + numAsiento + " no está disponible.");
        }

        scanner.close();
    }
}