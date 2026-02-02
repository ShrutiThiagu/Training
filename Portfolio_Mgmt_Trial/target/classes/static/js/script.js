async function check() {
    const s = document.getElementById('symbol').value;
    const res = await fetch(`/api/sentiment/${s}`);
    const data = await res.json();
    document.getElementById('res').classList.remove('hidden');
    document.getElementById('score').innerText = data.score + "% FOMO";
    document.getElementById('fill').style.width = data.score + "%";
    document.getElementById('fill').style.background = data.score > 70 ? 'red' : 'lime';
}