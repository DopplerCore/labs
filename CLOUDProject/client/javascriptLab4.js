
document.querySelector(".lab4").addEventListener('click', (e)=>{
	document.querySelector(".activeLab")?.classList.remove("activeLab");
	document.querySelector(".lab4").classList.add("activeLab");
	document.querySelector(".container").innerHTML = ``;
	document.querySelector(".container").innerHTML = `
            <div class="input">
                <div><input class="readerId" placeholder="id читателя"></input></div>
                <h2>Книги:</h2>
                <table class="booksTable">
                    <tr> <th>id</th>  <th>Описание</th> <th>Действие</th> </tr>
                <table/>
                <h2>Работники:</h2>
                <table class="employeesTable">
                    <tr> <th>id</th> <th>Описание</th> </tr>
                <table/>
                <h2>Читатели:</h2>
                <table class="readersTable">
                    <tr> <th>id</th> <th>Описание</th> </tr>
                <table/>
            </div>
	`;

    function showBooks(serverBooks){
        let booksTable = document.querySelector(".booksTable");
        for(let i = 0; i < serverBooks.length; i++){
            let tr = document.createElement("tr");
            let idtd = document.createElement("td");
            idtd.textContent = serverBooks[i].id;
            let texttd = document.createElement("td");
            texttd.innerHTML = `
            Название:${serverBooks[i].name}<br>
            Автор:${serverBooks[i].author}<br>
            Кол-во страниц:${serverBooks[i].pageNumber}<br>
            В библиотеке:${serverBooks[i].inLibrary ? "да" : "нет"}<br>
            id читателя:${serverBooks[i].readerId}
            `;
            let buttontd = document.createElement("td");
            let button = document.createElement("button");
            button.textContent = serverBooks[i].inLibrary ? "взять" : "вернуть";
            button.addEventListener("click", e=>{
                serverBooks[i].inLibrary = !(serverBooks[i].inLibrary);
                if(!serverBooks[i].inLibrary){
                    serverBooks[i].readerId = parseInt(document.querySelector(".readerId").value) ? parseInt(document.querySelector(".readerId").value) : 0;
                } else {
                    serverBooks[i].readerId = 0;
                }
                texttd.innerHTML = `
                Название:${serverBooks[i].name}<br>
                Автор:${serverBooks[i].author}<br>
                Кол-во страниц:${serverBooks[i].pageNumber}<br>
                В библиотеке:${serverBooks[i].inLibrary ? "да" : "нет"}<br>
                id читателя:${serverBooks[i].readerId}
                `;
                button.textContent = serverBooks[i].inLibrary ? "взять" : "вернуть";
                fetch('http://localhost:8080/api/books', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(serverBooks)
                });
            });
            buttontd.appendChild(button);
            tr.appendChild(idtd);
            tr.appendChild(texttd);
            tr.appendChild(buttontd);
            booksTable.appendChild(tr);
        }
    }

    function showEmployees(serverEmployees){
        let employeesTable = document.querySelector(".employeesTable");
        for(let i = 0; i < serverEmployees.length; i++){
            let tr = document.createElement("tr");
            let idtd = document.createElement("td");
            idtd.textContent = serverEmployees[i].id;
            let texttd = document.createElement("td");
            texttd.innerHTML = `
            Имя:${serverEmployees[i].name}<br>
            Фамилия:${serverEmployees[i].surname}<br>
            Стаж:${serverEmployees[i].experience}<br>
            Секция:${serverEmployees[i].section}
            `;
            tr.appendChild(idtd);
            tr.appendChild(texttd);
            employeesTable.appendChild(tr);
        }
    }

    function showReaders(serverReaders){
        let readersTable = document.querySelector(".readersTable");
        for(let i = 0; i < serverReaders.length; i++){
            let tr = document.createElement("tr");
            let idtd = document.createElement("td");
            idtd.textContent = serverReaders[i].id;
            let texttd = document.createElement("td");
            texttd.innerHTML = `
            Имя:${serverReaders[i].name}<br>
            Фамилия:${serverReaders[i].surname}<br>
            Дата регистрации:${serverReaders[i].registrationDate}
            `;
            tr.appendChild(idtd);
            tr.appendChild(texttd);
            readersTable.appendChild(tr);
        }
    }

    let props = [
        {
            URL:'http://localhost:8080/api/books',
            show: showBooks,
        },
        {
            URL:'http://localhost:8080/api/employees',
            show: showEmployees,
        },
        {
            URL:'http://localhost:8080/api/readers',
            show: showReaders,
        },
        
    ];
    
    props.forEach(prop => fetch(prop.URL)
        .then(res => res.ok ? res.json() : Promise.reject(res))
        .then(data => prop.show(data))
        .catch(err => console.error('Ошибка Fetch:', err))
    );
});

