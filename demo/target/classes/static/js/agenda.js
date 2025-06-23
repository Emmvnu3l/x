/*<![CDATA[*/
document.addEventListener('DOMContentLoaded', function() {
    // Solo necesitamos seleccionar las tarjetas que despliegan contenido
    const sectionCards = document.querySelectorAll('.agenda-section-card');
    const allDetailContents = document.querySelectorAll('.agenda-details-content');

    sectionCards.forEach(card => {
        card.addEventListener('click', function(event) {
            // Prevenimos el comportamiento por defecto si la tarjeta es un enlace (aunque no lo es en este caso)
            event.preventDefault();

            const targetId = this.dataset.target; // Obtiene el ID del contenido a mostrar
            const targetContent = document.getElementById(targetId);

            // Oculta todos los contenidos de detalle
            allDetailContents.forEach(content => {
                content.classList.remove('active');
            });

            // Muestra solo el contenido del apartado clicado
            if (targetContent) {
                targetContent.classList.add('active');
            }
        });
    });

    // NOTA: Los botones "Gestionar"/"Ver Detalle"/"Revisar" dentro de los li
    // no necesitan JavaScript aquí a menos que quieras una funcionalidad JS específica
    // (como abrir un modal, etc.). Si son enlaces a otras páginas, el HTML es suficiente.
});
/*]]>*/