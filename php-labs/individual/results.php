<?php
session_start();

// Проверяем, есть ли данные для отображения
if (!isset($_SESSION['project_info'])) {
    header('Location: index.php');
    exit;
}

$projectInfo = $_SESSION['project_info'];
$originalFilename = $_SESSION['original_filename'] ?? 'Неизвестно';

// Очищаем данные из сессии, кроме режима отладки
if (empty($_GET['debug'])) {
    unset($_SESSION['project_info']);
    unset($_SESSION['original_filename']);
}

require_once 'FlpParser.php';
$parser = new FlpParser();
?>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Результаты анализа - FL Studio Project Analyzer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        .main-container {
            background: rgba(255, 255, 255, 0.95);
            border-radius: 20px;
            box-shadow: 0 20px 40px rgba(0, 0, 0, 0.1);
            backdrop-filter: blur(10px);
        }
        .info-card {
            background: white;
            border-radius: 15px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.08);
            border-left: 4px solid #667eea;
            transition: transform 0.3s ease;
        }
        .info-card:hover {
            transform: translateY(-5px);
        }
        .plugin-badge {
            background: linear-gradient(45deg, #667eea, #764ba2);
            color: white;
            border: none;
            border-radius: 20px;
            padding: 8px 15px;
            margin: 5px;
            display: inline-block;
            font-size: 0.9rem;
        }
        .btn-custom {
            background: linear-gradient(45deg, #667eea, #764ba2);
            border: none;
            border-radius: 25px;
            padding: 12px 30px;
            color: white;
            font-weight: 600;
            transition: all 0.3s ease;
        }
        .btn-custom:hover {
            transform: translateY(-2px);
            box-shadow: 0 10px 20px rgba(102, 126, 234, 0.3);
            color: white;
        }
        .icon-large {
            font-size: 3rem;
            color: #667eea;
        }
        .stat-icon {
            font-size: 2rem;
            color: #667eea;
            margin-bottom: 10px;
        }
        .progress-custom {
            height: 8px;
            border-radius: 10px;
            background: rgba(102, 126, 234, 0.1);
        }
        .progress-bar-custom {
            background: linear-gradient(45deg, #667eea, #764ba2);
            border-radius: 10px;
        }
    </style>
</head>
<body>
    <div class="container py-5">
        <div class="row justify-content-center">
            <div class="col-lg-10">
                <div class="main-container p-5">
                    <!-- Заголовок -->
                    <div class="text-center mb-5">
                        <i class="fas fa-chart-line icon-large"></i>
                        <h1 class="display-5 fw-bold text-primary mb-3">Результаты анализа</h1>
                        <p class="lead text-muted">Информация о проекте FL Studio</p>
                    </div>

                    <!-- Основная информация о файле -->
                    <div class="row mb-4">
                        <div class="col-12">
                            <div class="info-card p-4">
                                <div class="d-flex align-items-center mb-3">
                                    <i class="fas fa-file-audio stat-icon me-3"></i>
                                    <div>
                                        <h4 class="mb-1 text-primary">Информация о файле</h4>
                                        <p class="text-muted mb-0">Основные данные загруженного проекта</p>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <strong>Имя файла:</strong> <?php echo htmlspecialchars($originalFilename); ?>
                                    </div>
                                    <div class="col-md-6">
                                        <strong>Размер файла:</strong> <?php echo $parser->formatFileSize($projectInfo['file_size']); ?>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Информация о проекте -->
                    <div class="row mb-4">
                        <div class="col-md-6">
                            <div class="info-card p-4 h-100">
                                <div class="d-flex align-items-center mb-3">
                                    <i class="fas fa-music stat-icon me-3"></i>
                                    <div>
                                        <h5 class="mb-1 text-primary">Название проекта</h5>
                                    </div>
                                </div>
                                <h4 class="text-dark"><?php echo htmlspecialchars($projectInfo['project_name']); ?></h4>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="info-card p-4 h-100">
                                <div class="d-flex align-items-center mb-3">
                                    <i class="fas fa-code-branch stat-icon me-3"></i>
                                    <div>
                                        <h5 class="mb-1 text-primary">Версия FL Studio</h5>
                                    </div>
                                </div>
                                <h4 class="text-dark"><?php echo htmlspecialchars($projectInfo['fl_version']); ?></h4>
                                <?php if (!empty($_GET['debug'])): ?>
                                <div class="mt-2 small text-muted">
                                    <?php
                                        $raw = $projectInfo['fl_version_raw'] ?? 0;
                                        $bytes = $projectInfo['fl_version_bytes'] ?? [0,0,0,0];
                                        $hex = strtoupper(str_pad(dechex($raw), 8, '0', STR_PAD_LEFT));
                                    ?>
                                    <div><strong>Raw:</strong> 0x<?php echo $hex; ?> (LE)</div>
                                    <div><strong>Bytes [b0,b1,b2,b3]:</strong> [<?php echo implode(',', $bytes); ?>]</div>
                                    <div class="text-secondary">Поделитесь этими значениями, если версия распознана неверно.</div>
                                </div>
                                <?php endif; ?>
                            </div>
                        </div>
                    </div>

                    <!-- Статистика проекта -->
                    <div class="row mb-4">
                        <div class="col-md-3">
                            <div class="info-card p-4 text-center h-100">
                                <i class="fas fa-layer-group stat-icon"></i>
                                <h3 class="text-primary mb-1"><?php echo $projectInfo['patterns_count']; ?></h3>
                                <p class="text-muted mb-0">Паттернов</p>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="info-card p-4 text-center h-100">
                                <i class="fas fa-sliders-h stat-icon"></i>
                                <h3 class="text-primary mb-1"><?php echo $projectInfo['channels_count']; ?></h3>
                                <p class="text-muted mb-0">Каналов</p>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="info-card p-4 text-center h-100">
                                <i class="fas fa-drum stat-icon"></i>
                                <h3 class="text-primary mb-1"><?php echo $projectInfo['tempo']; ?></h3>
                                <p class="text-muted mb-0">BPM</p>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="info-card p-4 text-center h-100">
                                <i class="fas fa-plug stat-icon"></i>
                                <h3 class="text-primary mb-1"><?php echo count($projectInfo['plugins']); ?></h3>
                                <p class="text-muted mb-0">Плагинов</p>
                            </div>
                        </div>
                    </div>

                    <!-- Список плагинов -->
                    <?php if (!empty($projectInfo['plugins'])): ?>
                    <div class="row mb-4">
                        <div class="col-12">
                            <div class="info-card p-4">
                                <div class="d-flex align-items-center mb-3">
                                    <i class="fas fa-puzzle-piece stat-icon me-3"></i>
                                    <div>
                                        <h5 class="mb-1 text-primary">Используемые плагины</h5>
                                        <p class="text-muted mb-0">Список обнаруженных плагинов и инструментов</p>
                                    </div>
                                </div>
                                <div class="plugins-container">
                                    <?php foreach ($projectInfo['plugins'] as $plugin): ?>
                                        <span class="plugin-badge">
                                            <i class="fas fa-plug me-1"></i>
                                            <?php echo htmlspecialchars($plugin); ?>
                                        </span>
                                    <?php endforeach; ?>
                                </div>
                            </div>
                        </div>
                    </div>
                    <?php else: ?>
                    <div class="row mb-4">
                        <div class="col-12">
                            <div class="info-card p-4 text-center">
                                <i class="fas fa-info-circle stat-icon text-warning"></i>
                                <h5 class="text-warning">Плагины не обнаружены</h5>
                                <p class="text-muted">В данном проекте не найдено информации о плагинах</p>
                            </div>
                        </div>
                    </div>
                    <?php endif; ?>

                    <!-- Список аудиодорожек / клипов -->
                    <?php if (!empty($projectInfo['audio_clips'])): ?>
                    <div class="row mb-4">
                        <div class="col-12">
                            <div class="info-card p-4">
                                <div class="d-flex align-items-center mb-3">
                                    <i class="fas fa-wave-square stat-icon me-3"></i>
                                    <div>
                                        <h5 class="mb-1 text-primary">Аудиодорожки и клипы</h5>
                                        <p class="text-muted mb-0">Список обнаруженных медиа-элементов плейлиста</p>
                                    </div>
                                </div>
                                <div class="plugins-container">
                                    <?php foreach ($projectInfo['audio_clips'] as $clip): ?>
                                        <span class="plugin-badge" style="background: linear-gradient(45deg, #20c997, #17a2b8);">
                                            <i class="fas fa-music me-1"></i>
                                            <?php echo htmlspecialchars($clip); ?>
                                        </span>
                                    <?php endforeach; ?>
                                </div>
                            </div>
                        </div>
                    </div>
                    <?php else: ?>
                    <div class="row mb-4">
                        <div class="col-12">
                            <div class="info-card p-4 text-center">
                                <i class="fas fa-info-circle stat-icon text-secondary"></i>
                                <h5 class="text-secondary">Аудиоклипы не обнаружены</h5>
                                <p class="text-muted">В проекте не найдено внешних аудиодорожек</p>
                            </div>
                        </div>
                    </div>
                    <?php endif; ?>

                    <!-- Кнопки действий -->
                    <div class="text-center mt-5">
                        <a href="index.php" class="btn btn-custom btn-lg me-3">
                            <i class="fas fa-upload me-2"></i>Анализировать другой файл
                        </a>
                        <button onclick="window.print()" class="btn btn-outline-primary btn-lg">
                            <i class="fas fa-print me-2"></i>Печать результатов
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        // Анимация появления карточек
        document.addEventListener('DOMContentLoaded', function() {
            const cards = document.querySelectorAll('.info-card');
            cards.forEach((card, index) => {
                card.style.opacity = '0';
                card.style.transform = 'translateY(20px)';
                
                setTimeout(() => {
                    card.style.transition = 'all 0.5s ease';
                    card.style.opacity = '1';
                    card.style.transform = 'translateY(0)';
                }, index * 100);
            });
        });
    </script>
</body>
</html>
