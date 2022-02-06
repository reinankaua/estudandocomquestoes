const showData = (data) => {
    for (let index = 0; index < data.length; index++) {

        const element = data[index];

        var header = document.querySelector('.header');
        var h1 = document.createElement("h1");
        var p = document.createElement("p");

        if (index < 1) {
            h1.innerHTML = 'Questões de Matemática';
            header.appendChild(h1);

            p.innerHTML = 'Aqui estão disponibilizadas algumas questões de matemática paro colocar o seu conhecimento em prática, e não se esqueça é estrema importância revisar o conteúdo apos um certo período de tempos. Bons estudos!'
            header.appendChild(p);
        }


        var form = document.querySelector('.form');
        var title = document.createElement('h2');
        var pQuestion = document.createElement('p');
        var pAltA = document.createElement('p');
        var pAltB = document.createElement('p');
        var pAltC = document.createElement('p');
        var pAltD = document.createElement('p');
        var pAltE = document.createElement('p');

        title.innerHTML = `Questão ${index + 1}`;
        form.appendChild(title);

        pQuestion.innerHTML = `${element.question}`;
        form.appendChild(pQuestion);

        pAltA.innerHTML = `A) ${element.alternativeA}`;
        form.appendChild(pAltA);

        pAltB.innerHTML = `B) ${element.alternativeB}`;
        form.appendChild(pAltB);

        pAltC.innerHTML = `C) ${element.alternativeC}`;
        form.appendChild(pAltC);

        pAltD.innerHTML = `D) ${element.alternativeD}`;
        form.appendChild(pAltD);

        pAltE.innerHTML = `E) ${element.alternativeE}`;
        form.appendChild(pAltE);
    }
}


fetch('https://api-estudandocomquestoes.herokuapp.com/matematica')
    .then(response => {
        response.json()
            .then(data => { showData(data); })
    })
    .catch(error => console.error(error))
