package z02_eng_v2II;

import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.File;
import java.io.IOException;
import javax.xml.transform.Transformer; 
import javax.xml.transform.TransformerException; 
import javax.xml.transform.TransformerFactory; 
import javax.xml.transform.dom.DOMSource; 
import javax.xml.transform.stream.StreamResult; 
import org.xml.sax.SAXException;

public class RentalShop {
    private static final String FILENAME = "./src/z02_eng_v2II/vehicles.xml";

    private ArrayList<Vehicle> vehicles;
    private Garage[] garages;

    public RentalShop(int numGarages) {
        this.vehicles = new ArrayList<>();
        this.garages = new Garage[numGarages];

        for (int i = 0; i < numGarages; i++) {
            garages[i] = new Garage();
        }

        loadVehiclesFromXML();
    }

    private void loadVehiclesFromXML() {
        try {
            File xmlFile = new File(FILENAME);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("Vehicles");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    int fuelType = Integer.parseInt(element.getElementsByTagName("Fuel_type").item(0).getTextContent());
                    int fuelQuantity = 0;

                    if (element.getElementsByTagName("Fuel_quantity").item(0) != null) {
                        fuelQuantity = Integer.parseInt(element.getElementsByTagName("Fuel_quantity").item(0).getTextContent());
                    }

                    Vehicle vehicle;

                    switch (element.getTagName()) {
                        case "Car":
                            vehicle = new Car(name, fuelType, fuelQuantity);
                            break;
                        case "Motorboat":
                            vehicle = new Motorboat(name, fuelType, fuelQuantity);
                            break;
                        case "Bicycle":
                            vehicle = new Bicycle(name);
                            break;
                        case "Scooter":
                            vehicle = new Scooter(name, fuelType, fuelQuantity);
                            break;
                        default:
                            continue;
                    }

                    vehicles.add(vehicle);
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void saveVehiclesToXML() {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element rootElement = doc.createElement("Vehicles");
            doc.appendChild(rootElement);

            for (Vehicle vehicle : vehicles) {
                Element vehicleElement;

                if (vehicle instanceof Car) {
                    vehicleElement = doc.createElement("Car");
                } else if (vehicle instanceof Motorboat) {
                    vehicleElement = doc.createElement("Motorboat");
                } else if (vehicle instanceof Bicycle) {
                    vehicleElement = doc.createElement("Bicycle");
                } else {
                    vehicleElement = doc.createElement("Scooter");
                }

                Element nameElement = doc.createElement("name");
                nameElement.appendChild(doc.createTextNode(vehicle.getName()));
                vehicleElement.appendChild(nameElement);

                Element fuelTypeElement = doc.createElement("Fuel_type");
                fuelTypeElement.appendChild(doc.createTextNode(Integer.toString(vehicle.getFuelType())));
                vehicleElement.appendChild(fuelTypeElement);

                if (vehicle.getFuelQuantity() > 0) {
                    Element fuelQuantityElement = doc.createElement("Fuel_quantity");
                    fuelQuantityElement.appendChild(doc.createTextNode(Integer.toString(vehicle.getFuelQuantity())));
                    vehicleElement.appendChild(fuelQuantityElement);
                }

                rootElement.appendChild(vehicleElement);
            }

            DOMSource source = new DOMSource(doc);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StreamResult result = new StreamResult(new File(FILENAME));
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        saveVehiclesToXML();
    }

    public void deleteVehicle(int id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId() == id) {
                vehicles.remove(vehicle);
                saveVehiclesToXML();
                break;
            }
        }
    }

    public void listVehicles() {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    public void sortVehiclesByParked() {
        vehicles.sort(new ParkedComparator());
    }

    public void sortVehiclesByType() {
        vehicles.sort(new VehicleTypeComparator());
    }

    public void sortVehiclesByName() {
        vehicles.sort(new VehicleNameComparator());
    }

    public void sortVehiclesByFuelType() {
        vehicles.sort(new FuelTypeComparator());
    }

    public void sortVehiclesByFuelQuantity() {
        vehicles.sort(new FuelQuantityComparator());
    }
}
