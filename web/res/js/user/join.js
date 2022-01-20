{
    const joinForm = document.querySelector('#join_form');

    if (joinForm) {
        const discAgreeAll = document.querySelector('#disc_agree_all');
        const discAgreeA = document.querySelector('#disc_agree_a');
        const discAgreeB = document.querySelector('#disc_agree_b');
        const discAgreeC = document.querySelector('#disc_agree_c');

        discAgreeAll.addEventListener('change', (e) => {
            discAgreeA.checked = e.currentTarget.checked;
            discAgreeB.checked = e.currentTarget.checked;
            discAgreeC.checked = e.currentTarget.checked;
        });
    }

    joinForm.onsubmit = () => {
        let inputs = joinForm.querySelectorAll('input');
        for (let i = 0; i < inputs.length; i++) {
            let input = inputs[i];
            let regexData = input.dataset.regex;
        }
    }
}