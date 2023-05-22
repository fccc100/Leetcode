var minLength = function (s) {
    function f(s) {
        let n = s.length

        if (s.indexOf('AB') < 0 && s.indexOf('CD') < 0) {
            return s.length
        }

        s = s.replaceAll('AB', '')
        s = s.replaceAll('CD', '')
        return f(s)
    }

    return f(s)
};