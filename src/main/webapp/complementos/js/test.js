/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var l = null;
var createSwatches = function() {
    for (var t = document.querySelectorAll(".output"), e = 0; e < t.length; e++)
        for (var r = t[e], n = getAttribute(r, "count"), a = r.attributes, o = 0; o < n; o++) {
            //for (var u = document.createElement("span"), l = 0; l < a.length; l++) u.setAttribute(a[l].name, a[l].value);
              for (var variable = document.createElement("div"), l = 0; l < a.length; l++) variable.setAttribute(a[l].name, a[l].value);
                variable.className = "swatch", r.appendChild(variable )
            //u.className = "swatch", r.appendChild(u)
        }
};

function renderLogo(t) {
    var e = document.getElementById("logo").childNodes,
        r = [];
    for (var n in e) {
        var a = e[n];
        a.attributes && r.push(a)
    }
    var o = randomColor({
        count: r.length,
        seed: t
    });
    for (var n in r) {
        r[n].setAttribute("fill", o[n])
    }
}
var renderDemo = function(t) {
    renderLogo(t);
    var e = document.querySelectorAll(".swatch");
    for (var r in e) {
        var n = {},
            a = e[r],
            o = a.attributes;
        if (o)
            for (var u = 0; u < o.length; u++) n[o[u].name] = o[u].value;
        n.count && delete n.count;
        l = randomColor(n);
        a.style && (a.style.background = l), a.innerHTML = l.toString()
        //console.log("color: " + l);

    }
};

function getAttribute(t, e) {
    for (var r in t.attributes)
        if (e === t.attributes[r].name) return t.attributes[r].value
}


