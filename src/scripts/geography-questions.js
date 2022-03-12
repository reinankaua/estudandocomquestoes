const showData = (data) => {
    for (let index = 0; index < data.length; index++) {

        const element = data[index];

        var header = document.querySelector('.header');
        var h1 = document.createElement("h1");
        var p = document.createElement("p");

        if (index < 1) {
            h1.innerHTML = 'Questões de Geografia';
            header.appendChild(h1);

            p.innerHTML = 'Aqui estão disponibilizadas algumas questões de geografia para colocar o seu conhecimento em prática, e não se esqueça é de extrema importância rever o conteúdo após um certo tempo. Bons estudos!'
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


const showCorrectResponse = (data) => {

    for (let index = 0; index < data.length; index++) {

        const element = data[index];

        document.querySelector('#reply').innerHTML = "Gabarito das Questões";

        if (element) {
            var ol = document.querySelector('#replyCard');
            var li = document.createElement('li');
            li.innerHTML = `${element.correct}`;
            ol.appendChild(li);
        }
        console.log(element.correct);
    }
}

function showResponse() {
    fetch('https://project-api-ecq.herokuapp.com/geografia')
        .then(response => {
            response.json()
                .then(data => {
                    showCorrectResponse(data);
                })
        })
        .catch(error => console.error(error))
}


fetch('https://project-api-ecq.herokuapp.com/geografia')
    .then(response => {
        response.json()
            .then(data => {
                showData(data);
            })
    })
    .catch(error => console.error(error))
