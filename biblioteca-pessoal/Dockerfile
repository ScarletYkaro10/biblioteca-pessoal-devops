# --- Estágio 1: Build (usando imagem com JDK e Maven) ---
# Usamos uma imagem que já contém o JDK 21 para compilar o projeto [cite: 186]
FROM maven:3.9.6-eclipse-temurin-21 as builder

WORKDIR /app
COPY . .
RUN mvn -B package -DskipTests

# --- Estágio 2: Runtime (usando imagem leve com JRE) ---
# Usamos uma imagem mais leve, apenas com o ambiente de execução Java (JRE) [cite: 187]
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app
# Copiamos apenas o arquivo .jar gerado no estágio anterior [cite: 187]
COPY --from=builder /app/target/*.jar app.jar

# Expomos a porta 8082 que configuramos no application.properties
EXPOSE 8082

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]