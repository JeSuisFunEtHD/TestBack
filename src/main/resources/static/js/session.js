export async function getSessionState() {
    try {
        const res = await fetch("/api/profile", {
            method: "GET",
            credentials: "include"
        });

        if (res.status === 401) {
            return { authorized: false };
        }

        if (res.status === 204) {
                    return { authorized: true, hasInfo: false };
                }

        const data = await res.json();

        const hasInfo = data !== null && Object.keys(data).length > 0;

        return {
            authorized: true,
            hasInfo: hasInfo
        };
    } catch (e) {
        console.error("Ошибка при проверке сессии:", e);
        return { authorized: false };
    }
}