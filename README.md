# Orquestador de Pods

<img src="https://upload.wikimedia.org/wikipedia/commons/3/39/Kubernetes_logo_without_workmark.svg" alt="Logo de Kubernetes" width="150">

Un **Cluster** es un conjunto de uno o varios **Nodos** (computadoras
virtuales). Cada Nodo tiene unidades de cómputo y de memoria que pueden ser
utilizadas por un **Pod**, la unidad mínima de ejecución de un programa.

- **Nodo**: tiene UMN (unidades de memoria libres), UCN (unidades de cómputo
  libres) y está alojado en una RN (región del nodo).
- **UnidadDeAlmacenamiento**: se aloja en una RUA (región de almacenamiento) y
  puede agregarse a un Pod.
- **Pod**: requiere UMP (memoria) y UCP (cómputo), y puede o no contar con una
  UnidadDeAlmacenamiento.

Un Pod puede colocarse en un Nodo si:
1. UMN > UMP,
2. UCN * 0.90 >= UCP, y
3. si el pod tiene UnidadDeAlmacenamiento, RUA == RN.

## Casos de uso

1. Calcular los recursos restantes del Nodo1 luego de agregarle el Pod1:
   - Nodo1: 100 UMN, 5 UCN, RN = "Buenos Aires"
   - Pod1: 90 UMP, 4 UCP, UnidadDeAlmacenamiento RUA = "Rosario"
2. Calcular los recursos restantes de Nodo1 y Nodo2 luego de agregar Pod1 y
   Pod2 al Cluster1:
   - Cluster1: Nodo1 y Nodo2
   - Nodo1: 100 UMN, 5 UCN, RN = "Buenos Aires"; Nodo2: 200 UMN, 10 UCN, RN = "Córdoba"
   - Pod1: 90 UMP, 4 UCP, UnidadDeAlmacenamiento RUA = "Buenos Aires"; Pod2: 100 UMP, 9 UCP

## Se pide:
- Código de pruebas en Smalltalk para cada uno de los casos de uso.
- Diagrama de secuencia para cada uno de los casos de uso.
- Diagrama de clases completo incluyendo todas las clases y abstracciones por
  más que no se utilicen en los diagramas de secuencia de los casos de uso.

# Soluciones

- [Ejercicio 1](diagrams/exercise_01)

## Ejecutar las pruebas

```
mvn test
```
